
package com.project.utils;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReadDataTest {

    @Mock
    private Workbook workbook;

    @Mock
    private Sheet sheet;

    @InjectMocks
    private ReadData readData;

    @Test
    void shouldReturnValueWhenKeyExists() throws IOException {
        String key = "testKey";
        String value = "testValue";
        Row row = mock(Row.class);
        Cell keyCell = mock(Cell.class);
        Cell valueCell = mock(Cell.class);

        when(workbook.getSheet(ReadData.DEFAULT_SHEET)).thenReturn(sheet);
        when(sheet.iterator()).thenReturn(java.util.Collections.singletonList(row).iterator());
        when(row.getCell(0)).thenReturn(keyCell);
        when(row.getCell(1)).thenReturn(valueCell);
        when(keyCell.getStringCellValue()).thenReturn(key);
        when(valueCell.getStringCellValue()).thenReturn(value);

        Optional<String> result = ReadData.readData(key);

        assertTrue(result.isPresent());
        assertEquals(value, result.get());
    }

    @Test
    void shouldReturnEmptyWhenKeyDoesNotExist() throws IOException {
        String key = "nonExistentKey";
        Row row = mock(Row.class);
        Cell keyCell = mock(Cell.class);

        when(workbook.getSheet(ReadData.DEFAULT_SHEET)).thenReturn(sheet);
        when(sheet.iterator()).thenReturn(java.util.Collections.singletonList(row).iterator());
        when(row.getCell(0)).thenReturn(keyCell);
        when(keyCell.getStringCellValue()).thenReturn("anotherKey");

        Optional<String> result = ReadData.readData(key);

        assertFalse(result.isPresent());
    }

    @Test
    void shouldWriteDataWhenKeyIsAbsent() throws IOException {
        String key = "newKey";
        String value = "newValue";
        Row row = mock(Row.class);

        when(workbook.getSheet(ReadData.DEFAULT_SHEET)).thenReturn(sheet);
        when(sheet.getLastRowNum()).thenReturn(-1); // No rows exist

        ReadData.writeData(key, value);

        verify(sheet).createRow(0);
        verify(sheet).createCell(0);
        verify(sheet).createCell(1);
        verify(sheet).getRow(0);
    }

    @Test
    void shouldUpdateDataWhenKeyExists() throws IOException {
        String key = "existingKey";
        String value = "updatedValue";
        Row row = mock(Row.class);
        Cell keyCell = mock(Cell.class);
        Cell valueCell = mock(Cell.class);

        when(workbook.getSheet(ReadData.DEFAULT_SHEET)).thenReturn(sheet);
        when(sheet.iterator()).thenReturn(java.util.Collections.singletonList(row).iterator());
        when(row.getCell(0)).thenReturn(keyCell);
        when(keyCell.getStringCellValue()).thenReturn(key);
        when(row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)).thenReturn(valueCell);

        ReadData.writeData(key, value);

        verify(valueCell).setCellValue(value);
    }

    @Test
    void shouldReturnCellDataWhenCellExists() throws IOException {
        int rowNum = 0;
        int colNum = 1;
        String expectedValue = "cellValue";
        Row row = mock(Row.class);
        Cell cell = mock(Cell.class);

        when(workbook.getSheet(ReadData.DEFAULT_SHEET)).thenReturn(sheet);
        when(sheet.getRow(rowNum)).thenReturn(row);
        when(row.getCell(colNum)).thenReturn(cell);
        when(cell.getStringCellValue()).thenReturn(expectedValue);

        String result = ReadData.getCellData(rowNum, colNum);

        assertEquals(expectedValue, result);
    }

    @Test
    void shouldReturnEmptyStringWhenCellDoesNotExist() throws IOException {
        int rowNum = 0;
        int colNum = 1;
        Row row = mock(Row.class);

        when(workbook.getSheet(ReadData.DEFAULT_SHEET)).thenReturn(sheet);
        when(sheet.getRow(rowNum)).thenReturn(row);
        when(row.getCell(colNum)).thenReturn(null);

        String result = ReadData.getCellData(rowNum, colNum);

        assertEquals("", result);
    }
}
