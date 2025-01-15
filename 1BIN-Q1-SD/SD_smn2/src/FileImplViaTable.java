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

	public E premier()throws FileVideException{
		if (estVide()) throw new FileVideException();
        return (E) table[indiceTete];

		
	}


	public E defile() throws FileVideException{
		if (estVide()) throw new FileVideException();
		E el = (E) table[indiceTete];
		indiceTete = (indiceTete+1)%table.length;
		taille--;
		return el;

	}


	public void enfile(E element){
		if (taille == table.length)
			agrandirTable();
		int i = (indiceTete+taille)% table.length;
		table[i] = element;
		taille++;
	}
	private void agrandirTable(){
		Object[] newTable = new Object[table.length*2];
		for (int i = 0; i < taille; i++) {
			newTable[i] = table[(indiceTete+i)%table.length];
		}
		table = newTable;
		indiceTete = 0;
	}

} 
