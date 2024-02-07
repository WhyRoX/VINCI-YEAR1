import java.util.Arrays;

// implementation de l'interface File via une table circulaire

/**
 * @author 
 *
 */

public class FileImplViaTable<E> implements File<E>{

	private Object[] table;  // ne modifiez pas cet identifiant, la classe test l'utilise					
	private int indiceTete;  // ne modifiez pas cet identifiant, la classe test l'utilise			
	private int taille;		// ne modifiez pas cet identifiant, la classe test l'utilise	
	// N'ajoutez pas d'autres attributs, la classe test risquerait de ne pas fonctionner
	

	public FileImplViaTable(){
		table = new Object[4];
		taille = 0;
		indiceTete = 0;
	}
	

	public boolean estVide(){
		return taille == 0;
	}


	public int taille(){
		return taille;
	}

	public E premier() throws FileVideException {
		if (estVide()) throw new FileVideException();
		return (E) table[indiceTete];
	}

	public E defile() throws FileVideException {
		if (estVide()) throw new FileVideException();
		E element = (E) table[indiceTete];

		indiceTete = (indiceTete + 1) % table.length;
		taille--;
		return element;
	}

	public void enfile(E element) {
		if (taille == table.length) {
			agrandirTable();
		}
		int index = (indiceTete + taille) % table.length;
		table[index] = element;
		taille++;
	}

	private void agrandirTable() {
		Object[] nouvelleTable = new Object[table.length * 2];

		for (int i = 0; i < taille; i++) {
			nouvelleTable[i] = table[(indiceTete + i) % table.length];
		}
		table = nouvelleTable;
		indiceTete = 0;
	}


} 
