package org.devary.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.devary.table.elements.FieldType;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEditStrategy {
    String fieldType;
}
