package org.devary;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.devary.table.Field;
import org.devary.table.TableContext;
import org.devary.table.utils.ContextLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

@QuarkusTest
class TestResponse {

    @Inject
    ContextLoader loader;
    static InputStream is;
    @BeforeAll
    static void beforeAll() {
        is = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("context/sharacter.yaml");
    }

    @Test
    void testBindingContext() {

        // when
        TableContext context = loader.load(is);

        // then
        assertThat(context).isNotNull();

        assertThat(context.getName()).isEqualTo("sharacter");
        assertThat(context.getPath()).isEqualTo("");
        assertThat(context.isAllowActions()).isTrue();

        assertThat(context.getAllowedActions()).isEmpty();
        assertThat(context.getDisabledActions()).isEmpty();
        assertThat(context.getDisabledFields()).isEmpty();

        assertThat(context.getFields())
                .hasSize(1);

        Field field = context.getFields().iterator().next();

        assertThat(field.getName()).isEqualTo("name");
        assertThat(field.getType()).isEqualTo("inputText");
        assertThat(field.getCreateEditStrategy()).isNotNull();
        assertThat(field.getCreateEditStrategy().getFieldType())
                .isEqualTo("inputText");

    }

    @Test
    void should_fail_when_context_does_not_exist() {
        assertThatThrownBy(() -> loader.load(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("context/XXX.yml")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input stream is null");
    }

}
