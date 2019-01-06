package trabajopractico3;

/**
 * Una lista gen�rica. Suponemos que cada nodo mantiene una referencia a un
 * Comparable, y no a un Object. La clase controla homogeneidad.
 *
 * @author Ing. Valerio Frittelli.
 * @version Octubre de 2011.
 */
import java.util.Comparator;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

public class SimpleList {
    // la direcci�n del primer nodo de la lista

    private Node frente;
    // la cantidad de nodos de la lista
    private int cantidad;

    /**
     * Constructor por defecto.
     */
    public SimpleList() {
        frente = null;
        cantidad = 0;
    }

    /**
     * Agrega el objeto x en la posici�n index de la lista. Los objetos que se
     * encontraban en la lista a partir de esa posicion, se desplazan hacia la
     * derecha. Se toma como convenci�n que el primer nodo esta en la posicion
     * cero. Note que el m�todo puede agregar un elemento en una lista vacia, o
     * un elemento al final de la lista, pero no puede insertar un elemento
     * "dejando nodos en blanco"...
     *
     * @param index el numero de orden del objeto a acceder.
     * @param x el objeto a almacenar en la posici�n index.
     * @throws IndexOutOfBoundsException si index esta fuera de rango (index <0
     * || index > size() ).
     * @throws ClassCastException si x no es compatible con el contenido de la
     * lista.
     */
    public void add(int index, Comparable x) {
        if (!isOk(x)) {
            throw new ClassCastException("Objeto incompatible");
        }
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Indice fuera del rango");
        }

        Node nuevo = new Node(x, frente);
        if (index == 0) {
            frente = nuevo;
        } else {
            Node p = frente;
            for (int i = 0; i < index - 1; i++) {
                p = p.getNext();
            }
            nuevo.setNext(p.getNext());
            p.setNext(nuevo);
        }

        cantidad++;
    }

    /**
     * Inserta un objeto al principio de la lista. La inserci�n se har� solo si
     * el par�metro recibido no es null y si el objeto representado es
     * compatible con el contenido actual de la lista.
     *
     * @param x el objeto a almacenar en la lista.
     */
    public void addFirst(Comparable x) {
        if (!isOk(x)) {
            return;
        }

        // si lleg� ac�, est� todo ok... inserte tranquilo
        Node p = new Node(x, frente);
        frente = p;
        cantidad++;
    }

    /**
     * Inserta un objeto en forma ordenada en la lista. La inserci�n se har�
     * solo si el par�metro recibido no es null y si el objeto representado es
     * compatible con el contenido actual de la lista. Se supone que la lista
     * est� ya ordenada (es decir, se supone que todas las inserciones fueron
     * realizadas llamando a este m�todo).
     *
     * @param x el objeto a almacenar en la lista.
     */
    public void addInOrder(Comparable x) {
        if (!isOk(x)) {
            return;
        }

        // si lleg� ac�, est� todo ok... inserte tranquilo
        Node nuevo = new Node(x, null);
        Node p = frente, q = null;
        while (p != null && x.compareTo(p.getInfo()) >= 0) {
            q = p;
            p = p.getNext();
        }
        nuevo.setNext(p);
        if (q != null) {
            q.setNext(nuevo);
        } else {
            frente = nuevo;
        }
        cantidad++;
    }

    /**
     * Inserta un objeto al final de la lista. La inserci�n se har� solo si el
     * par�metro recibido no es null y si el objeto representado es compatible
     * con el contenido actual de la lista.
     *
     * @param x el objeto a almacenar en la lista.
     */
    public void addLast(Comparable x) {
        if (!isOk(x)) {
            return;
        }

        Node nuevo = new Node(x, null);
        Node p = frente;
        while (p != null && p.getNext() != null) {
            p = p.getNext();
        }
        if (p != null) {
            p.setNext(nuevo);
        } else {
            frente = nuevo;
        }
        cantidad++;
    }

    /**
     * el metodo toma por parametro a b que es una lista y la concatena a la
     * lista original
     *
     * @param b
     * @return true si se pudo agregar la lista b a la lista invocante
     */
    public boolean addAll(SimpleList b) {
        boolean var = false;

        Node p = frente;
        while (p != null && p.getNext() != null) {
            p = p.getNext();
        }
        if (p != null) {
            p.setNext(b.frente);
            var = true;
        } else {
            frente = b.frente;
        }
        this.cantidad += b.size();


        return var;
    }

    /**
     * Remueve todos los elementos de la lista.
     */
    public void clear() {
        frente = null;
        cantidad = 0;
    }

    /**
     * Determina si en la lista existe un elemento que coincida con x. Usamos
     * compareTo() para realizar las comparaciones (aunque podr�a usarse
     * equals()).
     *
     * @return true si x est� en la lista - false si x no est� o si x es null.
     * @param x el objeto a buscar.
     */
    public boolean contains(Comparable x) {
        if (!isOk(x)) {
            return false;
        }

        Node p = frente;
        while (p != null && x.compareTo(p.getInfo()) != 0) {
            p = p.getNext();
        }
        return (p != null);
    }

    /**
     * Retorna (pero sin removerlo) el objeto ubicado en la posici�n "index" de
     * la lista, tomando como convenci�n que el primer nodo esta en la posicion
     * cero.
     *
     * @param index el numero de orden del objeto a acceder.
     * @return una referencia objeto ubicado en la posicion "index".
     * @throws IndexOutOfBoundsException si index esta fuera de rango.
     */
    public Comparable get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }


        Node p = frente;

        for (int i = 0; i < index; i++) {

            p = p.getNext();

        }

        return p.getInfo();


    }

    /**
     * Retorna (pero sin removerlo) el objeto ubicado al principio de la lista.
     *
     * @return una referencia al primer elemento de la lista.
     * @throws NoSuchElementException si la lista estaba vacia.
     */
    public Comparable getFirst() {
        if (frente == null) {
            throw new NoSuchElementException("Error: la lista esta vacia...");
        }
        return frente.getInfo();
    }

    /**
     * Retorna (pero sin removerlo) el objeto ubicado al final de la lista.
     *
     * @return una referencia al primer elemento de la lista.
     * @throws NoSuchElementExcpetion si la lista esta vacia.
     */
    public Comparable getLast() {
        if (frente == null) {
            throw new NoSuchElementException("Error: la lista esta vacia...");
        }
        Node p = frente;
        while (p.getNext() != null) {
            p = p.getNext();
        }
        return p.getInfo();
    }

    /**
     * Retorna el indice de la primera ocurrencia del objeto x en la lista, o -1
     * si x no est� en la lista o si x es null o si x no es compatible con el
     * contenido de la lista.
     *
     * @param x el objeto a buscar en la lista.
     * @return el indice de la primera ocurrencia de x en la lista, o -1 si x no
     * existe.
     */
    public int indexOf(Comparable x) {
        if (!isOk(x)) {
            return -1;
        }

        int c = 0;
        for (Node p = frente; p != null; p = p.getNext()) {
            if (x.compareTo(p.getInfo()) == 0) {
                return c;
            }
            c++;
        }
        return -1;
    }

    /**
     * Retorna true si la lista esta vacia.
     *
     * @return true si la lista esta vacia - false en caso contrario.
     */
    public boolean isEmpty() {
        return (frente == null);
    }

    /**
     * Remueve el objeto x en la posici�n index de la lista. Los objetos que se
     * encontraban a su derecha en la lista se desplazan hacia la izquierda una
     * posicion. Se toma como convenci�n que el primer nodo esta en la posicion
     * cero.
     *
     * @param index el numero de orden del objeto a acceder.
     * @return el objeto que se encontraba en la posicion index.
     * @throws IndexOutOfBoundsException si index esta fuera de rango (index <0
     * || index >= size() ).
     */
    public Comparable remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Indice fuera del rango");
        }

        Node p = frente, q = null;
        for (int i = 0; i < index; i++) {
            q = p;
            p = p.getNext();
        }

        Comparable x = p.getInfo();
        if (q == null) {
            frente = p.getNext();
        } else {
            q.setNext(p.getNext());
        }

        cantidad--;
        return x;
    }

    /**
     * Remueve el primer nodo de la lista que contenga al objeto x si el mismo
     * se encontraba en ella. Retorna true si la eliminacion tuvo exito, o false
     * en caso contrario (x no estaba en la lista, x era null, o x no era
     * compatible con el contenido de la lista).
     *
     * @param x el objeto a remover de la lista.
     * @return true si la eliminacion pudo hacerse, false en caso contrario.
     */
    public boolean remove(Comparable x) {
        if (!isOk(x)) {
            return false;
        }
        Node p = frente, q = null;
        while (p != null && x.compareTo(p.getInfo()) != 0) {
            q = p;
            p = p.getNext();
        }

        if (p == null) {
            return false;
        }

        if (q == null) {
            frente = p.getNext();
        } else {
            q.setNext(p.getNext());
        }
        cantidad--;

        return true;
    }

    /**
     * Retorna (y remueve) el objeto ubicado al principio de la lista.
     *
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista estaba vac�a.
     */
    public Comparable removeFirst() {
        if (frente == null) {
            throw new NoSuchElementException("Error: la lista esta vacia...");
        }

        Comparable x = frente.getInfo();
        frente = frente.getNext();

        cantidad--;
        return x;
    }

    /**
     * Remueve el primer nodo de la lista que contenga al objeto x si el mismo
     * se encontraba en ella. Equivale a invocar a remove(x). Retorna true si la
     * eliminacion tuvo exito, o false en caso contrario (x no estaba en la
     * lista, x era null, o x no era compatible con el contenido de la lista).
     *
     * @param x el objeto a remover de la lista.
     * @return true si la eliminacion pudo hacerse, false en caso contrario.
     */
    public boolean removeFirstOccurrence(Comparable x) {
        return remove(x);
    }

    /**
     * Retorna (y remueve) el objeto ubicado al final de la lista.
     *
     * @return el �ltimo elemento de la lista.
     * @throws NoSuchElementException si la lista estaba vac�a.
     */
    public Comparable removeLast() {
        if (frente == null) {
            throw new NoSuchElementException("Error: la lista esta vacia...");
        }

        Node p = frente, q = null;
        while (p.getNext() != null) {
            q = p;
            p = p.getNext();
        }
        Comparable x = p.getInfo();
        if (q != null) {
            q.setNext(p.getNext());
        } else {
            frente = p.getNext();
        }

        cantidad--;
        return x;
    }

    /**
     *
     * @param x
     * @return
     */
    public boolean removeAllOccurrence(Comparable x) {
        boolean v = false;
        if (!isOk(x)) {
            return false;
        }
        Node q = null;
        for (Node p = frente; p != null; p = p.getNext()) {
            if (x.compareTo(p.getInfo()) == 0) {
                remove(x);
                v = true;
            }
        }
        return v;
    }

    /**
     * Recorre la lista buscando un nodo que coincida con el objeto x, y si
     * existe, elimina la ultima ocurrencia, reesructurando la candidad de
     * nodos, (modificando el valor "size()").
     *
     * @param x el objeto a buscar en la lista.
     * @return true en caso de que la operacion se realice exitosamente y false
     * en caso contrario.
     */
    public boolean removeLastOccurrence(Comparable x) {
        if (!isOk(x)) {
            return false;
        }
        int leng = -1;
        int cont = 0;
        for (Node p = frente; p != null; p = p.getNext()) {
            if (x.compareTo(p.getInfo()) == 0) {
                leng = cont;
            }
            cont++;
        }
        if (leng == -1) {
            return false;
        } else {
            remove(leng);
            return true;
        }
    }

    /**
     * Busca un objeto x en la lista, y en caso de encontrarlo retorna una
     * referencia al objeto que EST� EN LA LISTA. Retorna null si x no est� en
     * la lista o si x es null o si x no es compatible con el contenido de la
     * lista.
     *
     * @param x el objeto a buscar en la lista.
     * @return una referencia al objeto encontrado en la lista.
     */
    public Comparable search(Comparable x) {
        if (!isOk(x)) {
            return null;
        }
        for (Node p = frente; p != null; p = p.getNext()) {
            if (x.compareTo(p.getInfo()) == 0) {
                return p.getInfo();
            }
        }
        return null;
    }

    /**
     * Reemplaza el objeto ubicado en la posici�n "index" de la lista, por el
     * objeto x que entra como parametro. Se toma como convenci�n que el primer
     * nodo esta en la posicion cero. El metodo retorna el objeto que se
     * encontraba previamente en la posicion index.
     *
     * @param index el numero de orden del objeto a acceder.
     * @param x el objeto a almacenar en la posici�n index.
     * @return el objeto previamente ubicado en la posicion index.
     * @throws IndexOutOfBoundsException si index esta fuera de rango.
     * @throws ClassCastException si x no es compatible con el contenido de la
     * lista.
     */
    public Comparable set(int index, Comparable x) {
        if (!isOk(x)) {
            throw new ClassCastException("Objeto incompatible");
        }
        if (index < 0 || index >= size()) {
            throw new NoSuchElementException("Indice fuera del rango");
        }

        Node p = frente;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }

        Comparable ant = p.getInfo();
        p.setInfo(x);
        return ant;
    }

    /**
     * Retorna la cantidad de objetos que contiene la lista.
     *
     * @return el tama�o de la lista.
     */
    public int size() {
        return cantidad;
    }

    /**
     * Redefine el m�todo toString heredado desde Object.
     *
     * @return el contenido de la lista convertido a String.
     */
    public String toString() {
        StringBuffer res = new StringBuffer("[ ");

        for (Node p = frente; p != null; p = p.getNext()) {
            res.append(p.toString());

            if (p.getNext() != null) {
                res.append(" - ");
            }

        }
        res.append(" ]");
        return res.toString();
    }

    // Este m�todo controla que x sea homogeneo con el contenido de la lista
    // Retorna true si es homog�neo y false en caso contrario
    private boolean isOk(Comparable x) {
        if (x == null) {
            return false;
        }
        if (frente != null && x.getClass() != frente.getInfo().getClass()) {
            return false;
        }
        return true;
    }

    /**
     * El metodo crea un arreglo y lo devuelve conteniendo en cada casillero un
     * nodo de la lista, uno por uno en el mismo orden.
     *
     * @return el arreglo.
     */
    public Comparable[] toArray() {
        Comparable vect[] = new Comparable[size()];


        int i = 0;
        for (Node p = frente; p != null; p = p.getNext()) {

            vect[i] = p.getInfo();
            i++;
        }
        return vect;

    }

    /**
     * El método recorre la lista comparando el valor de los nodos, chequeando
     * que los mismos se encuentren ordenados de menor a mayor
     *
     * @return true si la lista está ordenada de menor a mayor, o false en caso
     * contrario.
     *
     */
    public boolean isOrdered() {
        Node p = frente;
        Node q = null;
        int cont = 0;
        boolean orden = false;
        if (size() > 1) {

            while (p != null && p.getNext() != null) {
                q = p;
                p = p.getNext();
                if (p.getInfo().compareTo(q.getInfo()) >= 0) {
                } else {
                    //si este contador vale cero quiere decir que la lista se encuentra ordenada
                    cont++;
                }
            }
            if (cont == 0) {
                orden = true;
            }
        }
        return orden;
    }

    /**
     * El metodo busca el objeto x en la lista, y 
     * en caso de encontrarlo,  lo remueve del lugar donde 
     * lo encontró y lo reubica al principio de la lista. 
     * @return true si la operación tuvo éxito y false en caso contrario. 
     */
    public boolean moveToFront(Comparable x) {
        boolean u = false;
        if (!isOk(x)) {
            u = false;
        }
       // if (size() > 1) {

            Node q = null;
            Node p = frente;
            while (p != null && p.getInfo().compareTo(x) != 0) {
                q = p;
                p = p.getNext();
            }

            if (q != null && p != null) {
                q.setNext(p.getNext());
                p.setNext(frente);
                frente = p;
                u = true;
            }
        /*}else{
            u=false;
        }*/
        return u;
    }
}
