package mx.inova_core.infrastructure.utils;

public interface IGsonMap {
    <T> T toObject(String content, Class<T> type);
    String formObject(Object object);
}
