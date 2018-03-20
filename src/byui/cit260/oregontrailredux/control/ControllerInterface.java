package byui.cit260.oregontrailredux.control;

interface ControllerInterface<T> {
    public T create();
    public T getResource();
}
