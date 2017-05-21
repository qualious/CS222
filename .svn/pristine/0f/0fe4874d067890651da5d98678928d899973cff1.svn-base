package geography;

public class Town {
    private String name;
    private Province province;

    public Town(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public boolean equals(Object anObject) {
        if(anObject instanceof Town)
            return name.equals(((Town)anObject).name);
        return false;
    }

    public String toString() {
        return name;
    }
}
