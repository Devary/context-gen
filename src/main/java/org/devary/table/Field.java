package org.devary.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.devary.table.elements.CustomCallParams;
import org.devary.table.elements.ListType;
import org.devary.table.elements.ObjectFilter;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    String name;
    String type;
    ListType ListType;
    CustomCallParams customCallParams;
    ObjectFilter fieldObjectsFilter;
    CreateEditStrategy createEditStrategy;
}
