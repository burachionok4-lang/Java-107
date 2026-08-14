import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MutablePerson original = new MutablePerson("Иван", 30);
        List<String> originalTags = new ArrayList<>();
        originalTags.add("java");
        originalTags.add("immutable");

        ImmutableHolder holder = new ImmutableHolder("001", original, originalTags);

        System.out.println("До изменения: " + holder);

        original.setName("Олег");
        original.setAge(99);
        originalTags.add("Хакер");
        holder.getPerson().setName("Никита");
        //holder.getTags().add("ещё один"); // выбросит UnsupportedOperationException
        ImmutableHolder h1 = new ImmutableHolder("002", original, originalTags);
        ImmutableHolder h2 = new ImmutableHolder("002", original, originalTags);
        // Проверки
        System.out.println("После попыток изменения: " + holder);
        System.out.println("Первый холдер " + h2 + " Второй холдер " + h1);
        System.out.println(h1.equals(h2));
        System.out.println(h1.hashCode() == h2.hashCode());
    }
}