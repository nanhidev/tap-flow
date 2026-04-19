
package com.project.utils;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReadDataTest {

    @Mock
    private Workbook workbook;

    @InjectMocks
    private ReadData readData;

    @Mock
    private Sheet sheet;

    @Mock
    private Row row;

    @Mock
    private Cell keyCell;

    @Mock
    private Cell valueCell;

    @Test
    public void shouldReturnValueWhenKeyFound() throws IOException {
        String key = "testKey";
        String expectedValue = "testValue";

        when(ReadData.getWorkbook()).thenReturn(workbook);
        when(workbook.getSheet(ReadData.DEFAULT_SHEET)).thenReturn(sheet);
        when(sheet.iterator()).thenReturn(new Iterator<Row>() {
            private boolean hasNext = true;

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Row next() {
                hasNext = false; // only return one row for this test
                return row;
            }
        });
        when(row.getCell(0)).thenReturn(keyCell);
        when(keyCell.getCellType()).thenReturn(CellType.STRING);
        when(ReadData.FORMATTER.formatCellValue(keyCell)).thenReturn(key);
        when(row.getCell(1)).thenReturn(valueCell);
        when(valueCell.getCellType()).thenReturn(CellType.STRING);
        when(ReadData.FORMATTER.formatCellValue(valueCell)).thenReturn(expectedValue);

        Optional<String> result = ReadData.readData(key);

        assertTrue(result.isPresent());
        assertEquals(expectedValue, result.get());
    }

    @Test
    public void shouldReturnEmptyWhenKeyNotFound() throws IOException {
        String key = "nonExistentKey";

        when(ReadData.getWorkbook()).thenReturn(workbook);
        when(workbook.getSheet(ReadData.DEFAULT_SHEET)).thenReturn(sheet);
        when(sheet.iterator()).thenReturn(new Iterator<Row>() {
            private boolean hasNext = true;

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Row next() {
                hasNext = false; // only return one row for this test
                return row;
            }
        });
        when(row.getCell(0)).thenReturn(keyCell);
        when(keyCell.getCellType()).thenReturn(CellType.STRING);
        when(ReadData.FORMATTER.formatCellValue(keyCell)).thenReturn("differentKey");

        Optional<String> result = ReadData.readData(key);

        assertFalse(result.isPresent());
    }

    @Test
    public void shouldThrowExceptionWhenKeyIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ReadData.readData(null);
        });

        assertEquals("Key must not be null or blank", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenKeyIsBlank() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ReadData.readData("   ");
        });

        assertEquals("Key must not be null or blank", exception.getMessage());
    }

    @Test
    public void shouldWriteDataSuccessfullyWhenKeyExists() throws IOException {
        String key = "existingKey";
        String value = "newValue";

        when(ReadData.getWorkbook()).thenReturn(workbook);
        when(workbook.getSheet(ReadData.DEFAULT_SHEET)).thenReturn(sheet);
        when(sheet.iterator()).thenReturn(new Iterator<Row>() {
            private boolean hasNext = true;

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Row next() {
                hasNext = false; // only return one row for this test
                return row;
            }
        });
        when(row.getCell(0)).thenReturn(keyCell);
        when(keyCell.getCellType()).thenReturn(CellType.STRING);
        when(ReadData.FORMATTER.formatCellValue(keyCell)).thenReturn(key);
        when(row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)).thenReturn(valueCell);

        ReadData.writeData(key, value);

        verify(valueCell).setCellValue(value);
    }

    @Test
    public void shouldThrowExceptionWhenKeyIsNullOnWrite() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ReadData.writeData(null, "value");
        });

        assertEquals("Key must not be null or blank", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenValueIsNullOnWrite() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ReadData.writeData("key", null);
        });

        assertEquals("Value must not be null", exception.getMessage());
    }

    @Test
    public void shouldReturnCellDataSuccessfully() throws IOException {
        int rowNum = 0;
        int colNum = 0;
        String expectedValue = "cellValue";

        when(ReadData.getWorkbook()).thenReturn(workbook);
        when(workbook.getSheet(ReadData.DEFAULT_SHEET)).thenReturn(sheet);
        when(sheet.getRow(rowNum)).thenReturn(row);
        when(row.getCell(colNum)).thenReturn(keyCell);
        when(ReadData.FORMATTER.formatCellValue(keyCell)).thenReturn(expectedValue);

        String result = ReadData.getCellData(rowNum, colNum);

        assertEquals(expectedValue, result);
    }

    @Test
    public void shouldThrowExceptionWhenRowNumIsNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ReadData.getCellData(-1, 0);
        });

        assertEquals("Row and column indices must be non-negative (got row=-1, col=0)", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenColNumIsNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ReadData.getCellData(0, -1);
        });

        assertEquals("Row and column indices must be non-negative (got row=0, col=-1)", exception.getMessage());
    }
}
