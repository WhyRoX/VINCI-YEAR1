public interface FileDePriorite<E> extends Iterable<E> {

	/**
	 * insere un nouvel element dans la file de priorite.
	 * @param e le nouvel element a inserer
	 */
	void insere (E e);

	/**
	 * renvoie (sans le supprimer) l'element de plus grande priorite
	 * @return l'element de plus grande priorite ou null si la file de priorite est vide
	 */
	E max ();

}
