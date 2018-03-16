package byui.cit260.oregontrailredux.model.util;

import java.io.Serializable;
import java.util.Objects;

/**
 * A data structure that wraps a lambda function. Used to implement the Command
 * pattern.
 *
 * @author Connor
 */
public final class Command implements Serializable {

    /**
     * The function executed when the Command is run.
     */
    private final SerializableRunnable fn;

    /**
     * The default constructor.
     *
     * @param fn
     */
    public Command(final SerializableRunnable fn) {
        this.fn = fn;
    }

    /**
     * Executes the Command's encapsulated lambda function.
     */
    public void run() {
        this.fn.run();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.fn);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Command other = (Command) obj;
        return Objects.equals(this.fn, other.fn);
    }

    @Override
    public String toString() {
        return "Command{" + "fn=" + fn + '}';
    }
}
