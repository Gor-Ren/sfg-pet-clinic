package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(map.get(id));
    }

    public T save(T object) {
        Objects.requireNonNull(object);
        if (object.getId() == null) {
            object.setId(getNextId());
        }
        map.put(object.getId(), object);
        return object;
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId() {
        return map.keySet().stream()
                .max(Comparator.naturalOrder())
                .orElse(1L);
    }
}
