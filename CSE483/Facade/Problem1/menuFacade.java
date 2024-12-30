public class menuFacade {
    public veggie veggie;
    public nonveggie nonveggie;

    public menuFacade() {
        veggie = new veggie();
        nonveggie = new nonveggie();
    }

    public void showFullMenu() {
        System.out.println("Restaurant Full Menu:");
        System.out.println("---------------------");
        veggie.showMenu();
        System.out.println();
        nonveggie.showMenu();
    }
}
