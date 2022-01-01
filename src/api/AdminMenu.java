package api;

public class AdminMenu extends MainMenu {
    /**
     * this method displays the admin menu, extends to the MainMenu
     */
    public void display() {
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");
    }
}
