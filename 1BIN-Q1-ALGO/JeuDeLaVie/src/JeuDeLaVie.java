import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class JeuDeLaVie extends JFrame implements ActionListener, WindowListener {
	private TableauJeuDeLaVie jeu;
	private JButton next, initialiser, quitter;
	private JButton[][] cellules;
	private JPanel principal, damier, config, bouttons;
	private JTextField lo, la;
	private int longueur, largeur;
	private boolean initialise;

	public JeuDeLaVie() {
		try {
			UIManager.setLookAndFeel(new MetalLookAndFeel());
		} catch (Exception e) {
			System.out.println(e.getMessage()) ;
		}
		setTitle("Jeu de la Vie");
		creationFenetre() ;
		initialise = false;
		this.setContentPane(principal);
		this.addWindowListener(this);
		this.setSize(500, 500);
		this.setLocation(30, 30);
		this.setVisible(true);
	}
	
	public JeuDeLaVie(int largeur, int longueur) {
		try {
			UIManager.setLookAndFeel(new MetalLookAndFeel());
		} catch (Exception e) {
			System.out.println(e.getMessage()) ;
		}
		setTitle("Jeu de la Vie");
		creationFenetre() ;
		creationGrille(largeur,longueur) ;
		initialise = true;
		this.setContentPane(principal);
		this.addWindowListener(this);
		this.setSize(500, 500);
		this.setLocation(30, 30);
		this.setVisible(true);
	}

	
	private void creationFenetre() {
		setTitle("Jeu de la Vie");
		principal = new JPanel();
		principal.setLayout(new BorderLayout());
		config = new JPanel();
		config.setLayout(new GridLayout(1, 4));
		config.add(new JLabel("Nombre de lignes"));
		la = new JTextField("3");
		config.add(la);
		config.add(new JLabel("Nombre de colonnes"));
		lo = new JTextField("3");
		config.add(lo);
		principal.add(config, BorderLayout.NORTH);
		bouttons = new JPanel();
		bouttons.setLayout(new GridLayout(1, 5));
		initialiser = new JButton("Réinitialiser");
		initialiser.addActionListener(this);
		bouttons.add(initialiser);
		bouttons.add(new JLabel());
		next = new JButton("Génération suivante");
		next.addActionListener(this);
		bouttons.add(next);
		bouttons.add(new JLabel());
		quitter = new JButton("Quitter");
		quitter.addActionListener(this);
		bouttons.add(quitter);
		principal.add(bouttons, BorderLayout.SOUTH);
	}
	
	private void creationGrille(int largeur, int longueur) {
		this.longueur = longueur;
		this.largeur = largeur ;
		la.setText(""+largeur);
		lo.setText(""+longueur);
		jeu = new TableauJeuDeLaVie(largeur, longueur);
		cellules = new JButton[largeur][longueur];
		damier = new JPanel();
		damier.setLayout(new GridLayout(largeur, longueur));
		for (int i = 0; i < largeur; i = i + 1) {
			for (int j = 0; j < longueur; j = j + 1) {
				cellules[i][j] = new JButton("");
				cellules[i][j].addActionListener(this);
				cellules[i][j].setBackground(Color.WHITE);
				cellules[i][j].setForeground(Color.RED);
				cellules[i][j].setText("" + jeu.nbVoisines(i, j));
				damier.add(cellules[i][j]);
			}
		}
		principal.add(damier, BorderLayout.CENTER);
	}
	
	private void nouveauJeu(int largeur,int longueur) {
		principal.remove(damier);
		creationGrille(largeur,longueur) ;
		initialise = true;
		principal.revalidate();
		Graphics g = principal.getGraphics();
		principal.paint(g);
		initialise = true;
	}

	public void generationSuivante() {
		jeu.generationSuivante();
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				cellules[i][j].setText("" + jeu.nbVoisines(i, j));
				if (jeu.getXY(i, j))
					cellules[i][j].setBackground(Color.BLACK);
				else
					cellules[i][j].setBackground(Color.WHITE);
			}
		}
		principal.invalidate();
		principal.repaint();
	}
	
	public void pause(int temps) {
		try {
		    Thread.sleep(temps);
		}
		catch(InterruptedException ex)	{
		    return;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton jb = (JButton) e.getSource();
			if (jb == initialiser) {
				nouveauJeu(Integer.valueOf(la.getText()).intValue(),Integer.valueOf(lo.getText()).intValue());
			} else if (jb == quitter) {
				System.exit(0);
			} else if (jb == next) {
				generationSuivante();
			} else if (initialise) {
				int i = 0;
				boolean trouve = false;
				int j = 0;
				while ((i < largeur) && (!trouve)) {
					j = 0;
					while ((j < longueur) && (!trouve)) {
						if (cellules[i][j] == jb) {
							trouve = true;
						} else
							j = j + 1;
					}
					if (!trouve)
						i = i + 1;
				}
				if (trouve) {
					if (jeu.getXY(i, j))
						cellules[i][j].setBackground(Color.WHITE);
					else
						cellules[i][j].setBackground(Color.BLACK);
					jeu.setXY(i, j, !jeu.getXY(i, j));
					for (int i2 = 0; i2 < largeur; i2++) {
						for (int j2 = 0; j2 < longueur; j2++) {
							cellules[i2][j2].setText("" + jeu.nbVoisines(i2, j2));
						}
					}
					principal.invalidate();
					principal.repaint();
				}
			}
		}
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		e.getWindow().dispose();
		System.exit(0);
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {

	}

	public static void main(String[] args) {
		JeuDeLaVie jeu = new JeuDeLaVie(5,5);
	}

}