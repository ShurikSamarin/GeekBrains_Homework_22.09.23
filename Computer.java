class Computer {
    private String name;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Computer(String name, int ram, int storage, String os, String color) {
        this.name = name;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", ram=" + ram + ", storage=" + storage + ", os=" + os + ", color=" + color;};
    }
        
    

