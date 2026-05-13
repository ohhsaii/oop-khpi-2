package ua.khpi.oop.lab09.model;

// узагальнений клас для збереження запису про прогрес
public class ProgressEntry<TEntity, TValue> {
    private final TEntity entity;
    private final TValue value;

    public ProgressEntry(TEntity entity, TValue value) {
        this.entity = entity;
        this.value = value;
    }

    public TEntity getEntity() {
        return entity;
    }

    public TValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "запис: " + entity + ", результат: " + value;
    }
}