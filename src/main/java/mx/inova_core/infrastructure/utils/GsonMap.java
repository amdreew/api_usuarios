package mx.inova_core.infrastructure.utils;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GsonMap implements IGsonMap {
    @Override
    public <T> T toObject(String content, Class<T> type) {
        return new Gson().fromJson(content, type);
    }

    @Override
    public String formObject(Object object) {
        return new Gson().toJson(object);
    }
}
