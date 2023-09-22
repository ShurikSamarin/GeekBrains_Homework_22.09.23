import java.util.*;

public class Notebook {
    private Set<Computer> notebooks;

    public Notebook() {
        notebooks = new HashSet<>();
    }

    public void addComputer(Computer computer) {
        notebooks.add(computer);
    }

    public void filterNotebooks() {
        Map<Integer, String> criteriaMap = new HashMap<>();
        criteriaMap.put(1, "ОЗУ, Гб");
        criteriaMap.put(2, "Объем диска, Гб");
        criteriaMap.put(3, "Операционная система");
        criteriaMap.put(4, "Цвет");

        Scanner scanner = new Scanner(System.in);
        
        Map<String, String> filters = new HashMap<>();

        for (Map.Entry<Integer, String> entry : criteriaMap.entrySet()) {
            System.out.println("Введите значение для критерия \"" + entry.getValue() + "\":");
            String value = scanner.nextLine();
            filters.put(entry.getValue(), value);
        }
        scanner.close();
        List<Computer> filteredNotebooks = new ArrayList<>();
        boolean flag = true;
        for (Computer notebook : notebooks) {
            boolean passFilter = true;
            

            for (Map.Entry<String, String> entry : filters.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                switch (key) {
                    case "ОЗУ":
                        if (notebook.getRam() < Integer.parseInt(value)) {
                            passFilter = false;
                        }
                        break;
                    case "Объем диска":
                        if (notebook.getStorage() < Integer.parseInt(value)) {
                            passFilter = false;
                        }
                        break;
                    case "Операционная система":
                        if (!notebook.getOs().equalsIgnoreCase(value)) {
                            passFilter = false;
                        }
                        break;
                    case "Цвет":
                        if (!notebook.getColor().equalsIgnoreCase(value)) {
                            passFilter = false;
                        }
                        break;
                }

                if (!passFilter) {
                    break;
                }
                
            }

            if (passFilter) {
                filteredNotebooks.add(notebook);
                flag = false;
            }
        }
        System.out.println();
        System.out.println("Результаты фильтрации:");
        if (flag){
            System.out.println("Такой техники нет в наличии");
        }
        

        for (Computer notebook : filteredNotebooks) {
            System.out.println(notebook.toString());
        }
    }

    public static void main(String[] args) {
        Notebook notebook = new Notebook();

        // Добавление ноутбуков в множество
        notebook.addComputer(new Computer("Ноутбук 1", 8, 500, "Windows", "Black"));
        notebook.addComputer(new Computer("Ноутбук 2", 16, 1000, "MacOS", "Silver"));
        notebook.addComputer(new Computer("Ноутбук 3", 8, 500, "Windows", "White"));
        notebook.addComputer(new Computer("Ноутбук 4", 32, 1500, "Linux", "Red"));

        // Фильтрация и вывод результатов
        notebook.filterNotebooks();
    }
}
