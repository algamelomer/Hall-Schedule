package com.mycompany.myapp.methods;

import java.lang.reflect.Field;
import java.util.List;

public class MainMethods {

    // Generic method to convert any List of objects to Object[][]
    public <T> Object[][] convertListToObjectArray(List<T> objectList) {
        // Get the fields of the object's class dynamically
        if (objectList.isEmpty()) {
            return new Object[0][0]; // return empty if the list is empty
        }
        Field[] fields = objectList.get(0).getClass().getDeclaredFields();  // Get fields of the first object in the list
        int columns = fields.length;  // Number of columns corresponds to the number of fields
        int rows = objectList.size(); // Number of rows corresponds to the list size

        // Create the Object array with rows and columns
        Object[][] data = new Object[rows][columns];

        // Loop through the list and populate the object array dynamically
        for (int i = 0; i < rows; i++) {
            T obj = objectList.get(i);  // Get each object in the list
            for (int j = 0; j < columns; j++) {
                try {
                    // Make field accessible and get its value
                    fields[j].setAccessible(true);
                    data[i][j] = fields[j].get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return data;
    }

    // Generate column headers dynamically based on the fields of the object's class
    public <T> String[] getColumnHeaders(Class<T> clazz) {
        // Use reflection to get the field names dynamically
        Field[] fields = clazz.getDeclaredFields();
        String[] columnNames = new String[fields.length];

        for (int i = 0; i < fields.length; i++) {
            columnNames[i] = fields[i].getName(); // Use the field name as column header
        }

        return columnNames;
    }
}
