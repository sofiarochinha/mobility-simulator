package Manager;

public class Guide{

    private int guides;

    public Guide() {
        this.guides = 20;
    }

    public int getGuides() {
        return guides;
    }

    public void unavailable() {
        if (guides == 0)
            System.out.println("You must wait to a guide become available");
        else {
            guides -= 1;
        }

    }

    public void available() {
        guides += 1;
    }

}
