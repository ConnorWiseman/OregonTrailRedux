
package byui.cit260.oregontrailredux.control;

abstract class AbstractController<T> implements ControllerInterface {
    protected T resource;
        
    public AbstractController(final T resource) {
        this.resource = resource;
    }
    
    @Override
    public T getResource() {
        return this.resource;
    }
}
