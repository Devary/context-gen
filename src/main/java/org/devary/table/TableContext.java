package org.devary.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableContext {
    String name;
    String path;
    boolean allowActions;
    Set<String> allowedActions;
    String allowExportAction;//to add to the action list and delete it from here
    Set<String> disabledActions;
    Set<String> disabledFields;
    Set<Field> fields;
}
