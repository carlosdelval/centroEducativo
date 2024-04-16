package CentroEducativo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CentroEducativo.controladores.ControladorEstudiante;
import CentroEducativo.controladores.ControladorMateria;
import CentroEducativo.controladores.ControladorProfesor;
import CentroEducativo.controladores.ControladorValoracion;
import CentroEducativo.entities.Estudiante;
import CentroEducativo.entities.Materia;
import CentroEducativo.entities.Profesor;
import CentroEducativo.entities.SuperEntidad;
import CentroEducativo.entities.ValoracionMateria;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCentroEducativo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList listSelec;
	private JList listNoSelec;
	private DefaultListModel<Estudiante> listModelNoSeleccionados = new DefaultListModel();
	private DefaultListModel<Estudiante> listModelSeleccionados = new DefaultListModel();
	JComboBox jcbMateria;
	JComboBox jcbProfesor;
	JComboBox jcbNota;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelCentroEducativo frame = new PanelCentroEducativo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelCentroEducativo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblMateria = new JLabel("Materia:");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.anchor = GridBagConstraints.EAST;
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		panel.add(lblMateria, gbc_lblMateria);
		
		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel.add(lblProfesor, gbc_lblProfesor);
		
		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNota = new JLabel("Nota:");
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.anchor = GridBagConstraints.EAST;
		gbc_lblNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNota.gridx = 0;
		gbc_lblNota.gridy = 2;
		panel.add(lblNota, gbc_lblNota);
		
		jcbNota = new JComboBox();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filtrarEstudiantes();
			}
		});
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.anchor = GridBagConstraints.EAST;
		gbc_btnActualizar.gridx = 1;
		gbc_btnActualizar.gridy = 3;
		panel.add(btnActualizar, gbc_btnActualizar);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Alumnado no seleccionado");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 8));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alumnado seleccionado");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 8));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		listNoSelec = new JList(listModelNoSeleccionados);
		GridBagConstraints gbc_listNoSelec = new GridBagConstraints();
		gbc_listNoSelec.insets = new Insets(0, 0, 0, 5);
		gbc_listNoSelec.fill = GridBagConstraints.BOTH;
		gbc_listNoSelec.gridx = 0;
		gbc_listNoSelec.gridy = 1;
		panel_1.add(listNoSelec, gbc_listNoSelec);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveAllIzda();
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelCentroEducativo.class.getResource("/CentroEducativo/res/gotostart.png")));
		GridBagConstraints gbc_btnPrimero = new GridBagConstraints();
		gbc_btnPrimero.insets = new Insets(0, 0, 5, 0);
		gbc_btnPrimero.gridx = 1;
		gbc_btnPrimero.gridy = 0;
		panel_2.add(btnPrimero, gbc_btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveSeleccionadosIzda();
			}
		});
		btnAnterior.setIcon(new ImageIcon(PanelCentroEducativo.class.getResource("/CentroEducativo/res/previous.png")));
		GridBagConstraints gbc_btnAnterior = new GridBagConstraints();
		gbc_btnAnterior.insets = new Insets(0, 0, 5, 0);
		gbc_btnAnterior.gridx = 1;
		gbc_btnAnterior.gridy = 1;
		panel_2.add(btnAnterior, gbc_btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveSeleccionadosDerecha();
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelCentroEducativo.class.getResource("/CentroEducativo/res/next.png")));
		GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
		gbc_btnSiguiente.insets = new Insets(0, 0, 5, 0);
		gbc_btnSiguiente.gridx = 1;
		gbc_btnSiguiente.gridy = 2;
		panel_2.add(btnSiguiente, gbc_btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveAllDerecha();
			}
		});
		btnUltimo.setIcon(new ImageIcon(PanelCentroEducativo.class.getResource("/CentroEducativo/res/gotoend.png")));
		GridBagConstraints gbc_btnUltimo = new GridBagConstraints();
		gbc_btnUltimo.gridx = 1;
		gbc_btnUltimo.gridy = 3;
		panel_2.add(btnUltimo, gbc_btnUltimo);
		
		listSelec = new JList(listModelSeleccionados);
		GridBagConstraints gbc_listSelec = new GridBagConstraints();
		gbc_listSelec.fill = GridBagConstraints.BOTH;
		gbc_listSelec.gridx = 2;
		gbc_listSelec.gridy = 1;
		panel_1.add(listSelec, gbc_listSelec);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 2;
		contentPane.add(btnGuardar, gbc_btnGuardar);
		
		
		cargarMaterias();
		cargarProfesores();
		cargarNotas();
	}
	
	/**
	 *Carga todas las materias en jCombo
	 */
	
	private void cargarMaterias() {
		ControladorMateria cm = new ControladorMateria();
		List<Materia> l = (List<Materia>) cm.findAll();
		for(Materia m : l) {
			jcbMateria.addItem(m);
		}
	}
	
	/**
	 *Carga todas las notas del 1 al 10 en jCombo
	 */
	
	private void cargarNotas() {
		for (int i = 1; i < 11; i++) {
			jcbNota.addItem(i);
		}
	}
	
	/**
	 * Carga todos los profesores en el jCombo
	 */
	
	private void cargarProfesores() {
		ControladorProfesor cm = new ControladorProfesor();
		List<Profesor> l = (List<Profesor>) cm.findAll();
		for(Profesor p : l) {
			jcbProfesor.addItem(p);
		}
	}
	
	/**
	 *Filtra estudiantes y los mete en una lista u otra de seleccionados o no seleccionados
	 */
	
	private void filtrarEstudiantes() {
		listModelNoSeleccionados.clear();
		listModelSeleccionados.clear();
		ControladorValoracion cmV = new ControladorValoracion();
		ControladorEstudiante cmE = new ControladorEstudiante();
		List<Estudiante> estudiantes = (List<Estudiante>) cmE.findAll();
		for(Estudiante e : estudiantes) {
			ValoracionMateria valoracion = cmV.filtraValoracion(e.getId(), ((Profesor)jcbProfesor.getSelectedItem()).getId(),
					((Materia)jcbMateria.getSelectedItem()).getId());
			if(valoracion != null && valoracion.getValoracion() == (int) jcbNota.getSelectedItem()) {
				listModelSeleccionados.addElement(e);
			}else {
				listModelNoSeleccionados.addElement(e);
			}
		}	
	}
	
	/**
	 * Método que pasa de izda a derecha
	 */
	
	private void moveAllDerecha() {
		List<Estudiante> l = new ArrayList<Estudiante>();
		
		for (int i = 0; i < listModelNoSeleccionados.size(); i++) {
			l.add(listModelNoSeleccionados.getElementAt(i));
		}
		
		listModelNoSeleccionados.clear();
		
		for (int i = 0; i < l.size(); i++) {
			listModelSeleccionados.addElement(l.get(i));
		}
	}
	
	/**
	 * Método que pasa de derecha a izda
	 */
	
	private void moveAllIzda() {
		List<Estudiante> l = new ArrayList<Estudiante>();
		
		for (int i = 0; i < listModelSeleccionados.size(); i++) {
			l.add(listModelSeleccionados.getElementAt(i));
		}
		
		listModelSeleccionados.clear();
		
		for (int i = 0; i < l.size(); i++) {
			listModelNoSeleccionados.addElement(l.get(i));
		}
	}
	
	/**
	 * Método que pasa estudiantes seleccionados de izda a derecha
	 * Hago el bucle a la inversa para evitar problemas de indices al eliminar elementos
	 */
	
	private void moveSeleccionadosDerecha() {
		
		int[] seleccionados = listNoSelec.getSelectedIndices();
		
		for (int i = seleccionados.length - 1; i >= 0; i--) {
	        int indice = seleccionados[i];
	        Estudiante e = listModelNoSeleccionados.getElementAt(indice);
	        listModelSeleccionados.addElement(e);
	        listModelNoSeleccionados.remove(indice);
	    }
	}
	
	/**
	 * Método que pasa estudiantes seleccionados de derecha a izda
	 */
	
	private void moveSeleccionadosIzda() {
		
		int[] seleccionados = listSelec.getSelectedIndices();
		
		for (int i = seleccionados.length - 1; i >= 0; i--) {
	        int indice = seleccionados[i];
	        Estudiante e = listModelSeleccionados.getElementAt(indice);
	        listModelSeleccionados.remove(indice);
	        listModelNoSeleccionados.addElement(e);
	    }
	}
	
	/**
	 * Método que guarda los cambios
	 */

	private void guardar() {
		ControladorValoracion cv = new ControladorValoracion();
		int notaActual = (int)jcbNota.getSelectedItem();
		int idProfesor = ((Profesor)jcbProfesor.getSelectedItem()).getId();
		int idMateria = ((Materia)jcbMateria.getSelectedItem()).getId();
		
		for (int i = 0; i < listModelSeleccionados.getSize(); i++) {
			int idEstudiante = listModelSeleccionados.get(i).getId();
			ValoracionMateria vm = cv.filtraValoracion(idEstudiante, idProfesor, idMateria);
			if(vm != null) cv.update(vm,notaActual);
			else cv.persist(notaActual,idEstudiante, idProfesor, idMateria);
		}
	}
}
