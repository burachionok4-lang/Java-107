import java.util.List;
import java.util.Objects;

public final class ImmutableHolder {

    private final String id;
    private final MutablePerson person;
    private final List<String> tags;
    public ImmutableHolder(String id, MutablePerson person, List<String> tags) {
        this.id = Objects.requireNonNull(id);
        this.person = new MutablePerson(person);
        this.tags = List.copyOf(tags);
    }

    public String getId() {
        return id;
    }
    public MutablePerson getPerson() {
        return new MutablePerson(person);
    }
    public List<String> getTags() {
        return List.copyOf(tags);
    }
    @Override
    public String toString() {
        return "ImmutableHolder{id='" + id + "', person=" + person + ", tags=" + tags + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableHolder that = (ImmutableHolder) o;
        return id.equals(that.id) && person.equals(that.person) && tags.equals(that.tags);
    }
    @Override
    public  int hashCode(){
        return Objects.hash(id,person,tags);
    }
}
