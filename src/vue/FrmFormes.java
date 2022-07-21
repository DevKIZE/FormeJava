package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controleur.Controle;
import modele.Carre;
import modele.Rond;
import modele.Forme;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class FrmFormes extends JFrame {

	private JPanel contentPane;
	private JTextField txtCoteCarre;
	private JTextField txtRayonRond;
	private JLabel lblPerimetreCarre;
	private JLabel lblSurfaceCarre;
	private JLabel lblPerimetreRond;
	private JLabel lblSurfaceRond;
	private JList lstFormes;
	private Controle controle;
	private DefaultListModel contenuLstFormes =  new DefaultListModel();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFormes frame = new FrmFormes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	/**
	 * clic sur le bouton calcul du carre
	 */
	public void cmdCalculCarre() {
		controle.demandeFrmFormesValeurs("carré", Float.parseFloat(txtCoteCarre.getText()));
	}
	
	/**
	 * clic sur le bouton calcul du rond
	 */
	public void cmdCalculRond() {
		controle.demandeFrmFormesValeurs("rond", Float.parseFloat(txtRayonRond.getText()));
	}
	
	/**
	 * clic sur le bouton del
	 */
	public void cmdDel() {
		int[] lesIndices = lstFormes.getSelectedIndices();
		for (int k=lesIndices.length-1; k>=0; k--) {
			controle.demandeFrmFormesDel(lesIndices[k]);
		}
	}
	
	/**
	 * Remplir la liste avec les informations des formes
	 * @param lesFormes
	 */
	public void majLstFormes(ArrayList<Forme> lesFormes) {
		//vider la liste
		contenuLstFormes.clear();
		//boucle pour remplir la liste
		for (Forme uneForme : lesFormes) {
			String ligne;
			if (uneForme instanceof Carre) {
				ligne = "CARRE : cote="+((Carre)uneForme).getCote();
			}else {
				ligne = "ROND : rayon="+((Rond)uneForme).getRayon();
			}
			ligne += " perimetre="+uneForme.perimetre()+" surface="+uneForme.surface();
			//ajout dans la liste
			contenuLstFormes.addElement(ligne);
		}
		
	}
	
	/**
	 * Affichage du perimetre et de la surface du carré
	 * @param perimetre
	 * @param surface
	 */
	public void afficheResultCarre(float perimetre, float surface) {
		lblPerimetreCarre.setText(""+perimetre);
		lblSurfaceCarre.setText(""+surface);
	}

	/**
	 * Affichage du perimetre et de la surface du rond
	 * @param perimetre
	 * @param surface
	 */
	public void afficheResultRond(float perimetre, float surface) {
		lblPerimetreRond.setText(""+perimetre);
		lblSurfaceRond.setText(""+surface);
	}
	
	/**
	 * Create the frame.
	 */
	public FrmFormes(Controle controle) {
		this.controle = controle;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 767);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FrmFormes.class.getResource("/media/carre.jpg")));
		lblNewLabel.setBounds(10, 11, 190, 177);
		contentPane.add(lblNewLabel);
		
		JLabel lblCoteCarre = new JLabel("c\u00F4t\u00E9 =");
		lblCoteCarre.setBounds(223, 41, 46, 14);
		contentPane.add(lblCoteCarre);
		
		JLabel lblNewLabel_1 = new JLabel("p\u00E9rim\u00E8tre =");
		lblNewLabel_1.setBounds(223, 65, 91, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("surface =");
		lblNewLabel_2.setBounds(223, 103, 70, 14);
		contentPane.add(lblNewLabel_2);
		
		txtCoteCarre = new JTextField();
		txtCoteCarre.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCoteCarre.setBounds(302, 38, 86, 20);
		contentPane.add(txtCoteCarre);
		txtCoteCarre.setColumns(10);
		
		lblPerimetreCarre = new JLabel("0");
		lblPerimetreCarre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerimetreCarre.setBounds(312, 70, 75, 14);
		contentPane.add(lblPerimetreCarre);
		
		lblSurfaceCarre = new JLabel("0");
		lblSurfaceCarre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurfaceCarre.setBounds(310, 103, 78, 14);
		contentPane.add(lblSurfaceCarre);
		
		JButton btnCalculCarre = new JButton("Calcul");
		btnCalculCarre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdCalculCarre();
			}
		});
		btnCalculCarre.setBounds(431, 37, 89, 23);
		contentPane.add(btnCalculCarre);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(FrmFormes.class.getResource("/media/rond.jpg")));
		lblNewLabel_3.setBounds(10, 203, 190, 193);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblCoteRond = new JLabel("c\u00F4t\u00E9 =");
		lblCoteRond.setBounds(223, 203, 46, 14);
		contentPane.add(lblCoteRond);
		
		JLabel de = new JLabel("p\u00E9rim\u00E8tre =");
		de.setBounds(223, 243, 83, 18);
		contentPane.add(de);
		
		JLabel sa = new JLabel("surface =");
		sa.setBounds(223, 292, 70, 14);
		contentPane.add(sa);
		
		txtRayonRond = new JTextField();
		txtRayonRond.setHorizontalAlignment(SwingConstants.RIGHT);
		txtRayonRond.setBounds(302, 200, 86, 20);
		contentPane.add(txtRayonRond);
		txtRayonRond.setColumns(10);
		
		lblPerimetreRond = new JLabel("0");
		lblPerimetreRond.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerimetreRond.setBounds(342, 245, 46, 14);
		contentPane.add(lblPerimetreRond);
		
		lblSurfaceRond = new JLabel("0");
		lblSurfaceRond.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurfaceRond.setBounds(342, 292, 46, 14);
		contentPane.add(lblSurfaceRond);
		
		JButton btnCalculRond = new JButton("Calcul");
		btnCalculRond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdCalculRond();
			}
		});
		btnCalculRond.setBounds(431, 199, 89, 23);
		contentPane.add(btnCalculRond);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 454, 510, 203);
		contentPane.add(scrollPane);
		
		lstFormes = new JList(contenuLstFormes);
		scrollPane.setViewportView(lstFormes);
		
		JButton btnDel = new JButton("Del");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdDel();
			}
		});
		btnDel.setBounds(431, 679, 89, 23);
		contentPane.add(btnDel);
	}
}
