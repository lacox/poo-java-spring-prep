package servicio_bibliotecario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {
	/**
	 * @author lacox(Angel David Salas Mendoza)
	 */
	private static final long serialVersionUID = 1L;
	final String archivo = "Archpe.txt";
	private LinkedList<Libro> libros = new LinkedList<>();;
	private LinkedList<Usuario> usuarios = new LinkedList<>();;
	private LinkedList<Prestamo> prestamos = new LinkedList<>();;
	
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenu Archivo;
	private javax.swing.JMenuItem GuardarArchivo;
	private javax.swing.JTextField IdU;
	private javax.swing.JTextField NombreU;
	private javax.swing.JTextField ApellidoMU;
    private javax.swing.JTextField ApellidoPU;
    private javax.swing.JTextField DireccionU;
    private javax.swing.JTextField IdL;
    private javax.swing.JTextField AutorL;
    private javax.swing.JTextField EdicionL;
    private javax.swing.JTextField EditorialL;
    private javax.swing.JTextField IdP;
    private javax.swing.JTextField FechaEP;
    private javax.swing.JTextField FechaSP;
    private javax.swing.JTextField IdLP;
    private javax.swing.JTextField IdUP;
    private javax.swing.JTextArea TextC;
    private javax.swing.JButton CancelarRL;
    private javax.swing.JButton CancelarRP;
    private javax.swing.JButton CancelarRU;
    private javax.swing.JButton Consultar;
    private javax.swing.JButton GuardarRL;
    private javax.swing.JButton GuardarRU;
    private javax.swing.JButton PrestarRP;
    private javax.swing.JButton Registrar;
    private javax.swing.JComboBox<String> Opcion;
    private javax.swing.JComboBox<String> StatusL;
    private javax.swing.JComboBox<String> TipoU;
    private javax.swing.JPanel PanelRL;
    private javax.swing.JPanel PanelRP;
    private javax.swing.JPanel PanelRU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;

	public Principal() {
		initComponents();
		PanelRU.setVisible(false);
        PanelRL.setVisible(false);
        PanelRP.setVisible(false);
        setSize(368, 445);
        setLocationRelativeTo(null);
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
			DatosBibliotecarios datos = (DatosBibliotecarios) ois.readObject();
			usuarios = datos.getUsuarios();
			libros = datos.getLibros();
			prestamos = datos.getPrestamos();
			JOptionPane.showMessageDialog(null, "Se ha recuperado el archivo");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El sistema no puede encontrar el archivo");
			System.out.println("Error: "+e.getMessage());
		} 
        for (int i = 0; i < prestamos.size(); i++) {
			prestamos.get(i).Contador(TextC);
			if (prestamos.get(i).isBorrar()) {
				prestamos.remove(i);
			}
		}
	}
	
	private void initComponents() {
		jScrollPane1 = new javax.swing.JScrollPane();
		PanelRU = new javax.swing.JPanel();
        DireccionU = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        GuardarRU = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TipoU = new javax.swing.JComboBox<>();
        CancelarRU = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IdU = new javax.swing.JTextField();
        NombreU = new javax.swing.JTextField();
        ApellidoPU = new javax.swing.JTextField();
        ApellidoMU = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Opcion = new javax.swing.JComboBox<>();
        Registrar = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        PanelRL = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        StatusL = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        EdicionL = new javax.swing.JTextField();
        IdL = new javax.swing.JTextField();
        EditorialL = new javax.swing.JTextField();
        AutorL = new javax.swing.JTextField();
        CancelarRL = new javax.swing.JButton();
        GuardarRL = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextC = new javax.swing.JTextArea();
        PanelRP = new javax.swing.JPanel();
        CancelarRP = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        IdP = new javax.swing.JTextField();
        FechaEP = new javax.swing.JTextField();
        IdUP = new javax.swing.JTextField();
        FechaSP = new javax.swing.JTextField();
        PrestarRP = new javax.swing.JButton();
        IdLP = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        GuardarArchivo = new javax.swing.JMenuItem();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Id:");
        jLabel2.setText("Nombre:");
        jLabel3.setText("Apellido Paterno:");
        jLabel4.setText("Apellido Materno:");
        jLabel5.setText("Dirección:");
        jLabel6.setText("Tipo:");
        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel7.setText("Registro de usuario");
        
        TipoU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Estudiante" }));

        GuardarRU.setText("Guardar");
        GuardarRU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarRUActionPerformed(evt);
            }
        });

        CancelarRU.setText("Cancelar");
        CancelarRU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarRUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRULayout = new javax.swing.GroupLayout(PanelRU);
        PanelRU.setLayout(PanelRULayout);
        PanelRULayout.setHorizontalGroup(
            PanelRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRULayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRULayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TipoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(GuardarRU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelarRU))
                    .addGroup(PanelRULayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(PanelRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelRULayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DireccionU))
                            .addGroup(PanelRULayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(2, 2, 2)
                                .addComponent(ApellidoMU))
                            .addGroup(PanelRULayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ApellidoPU))
                            .addGroup(PanelRULayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NombreU))
                            .addGroup(PanelRULayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IdU)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRULayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(49, 49, 49)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelRULayout.setVerticalGroup(
            PanelRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRULayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IdU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NombreU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ApellidoPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ApellidoMU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(DireccionU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TipoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(GuardarRU)
                        .addComponent(CancelarRU))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        jLabel8.setText("Id:");
        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel9.setText("Registro de Libros");
        jLabel10.setText("Status:");
        jLabel11.setText("Autor:");
        jLabel12.setText("Edicion:");
        jLabel13.setText("Editorial:");
        
        StatusL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Ocupado" }));
        Opcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Opciones--", "Usuarios", "Libros", "Prestamos" }));

        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        CancelarRL.setText("Cancelar");
        CancelarRL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarRLActionPerformed(evt);
            }
        });

        GuardarRL.setText("Guardar");
        GuardarRL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarRLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRLLayout = new javax.swing.GroupLayout(PanelRL);
        PanelRL.setLayout(PanelRLLayout);
        PanelRLLayout.setHorizontalGroup(
            PanelRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRLLayout.createSequentialGroup()
                        .addGroup(PanelRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGroup(PanelRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRLLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(StatusL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelRLLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(IdL, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelRLLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(16, 16, 16)
                        .addComponent(AutorL, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelRLLayout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(EdicionL, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelRLLayout.createSequentialGroup()
                                .addComponent(GuardarRL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CancelarRL))
                            .addGroup(PanelRLLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EditorialL, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelRLLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelRLLayout.setVerticalGroup(
            PanelRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(IdL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(StatusL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(AutorL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(EdicionL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(EditorialL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardarRL)
                    .addComponent(CancelarRL))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        jLabel14.setText("Id:");
        jLabel15.setText("Fecha entrada:");
        jLabel16.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel16.setText("Registro de préstamo");
        jLabel17.setText("Fecha salida:");
        jLabel18.setText("Id libro:");
        jLabel19.setText("Id usuario:");

        FechaEP.setToolTipText("AAAA-MM-DD");
        FechaSP.setToolTipText("AAAA-MM-DD");

        TextC.setEditable(false);
        TextC.setColumns(20);
        TextC.setRows(5);
        jScrollPane1.setViewportView(TextC);

        CancelarRP.setText("Cancelar");
        CancelarRP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarRPActionPerformed(evt);
            }
        });

        PrestarRP.setText("Prestar");
        PrestarRP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrestarRPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRPLayout = new javax.swing.GroupLayout(PanelRP);
        PanelRP.setLayout(PanelRPLayout);
        PanelRPLayout.setHorizontalGroup(
            PanelRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRPLayout.createSequentialGroup()
                .addGroup(PanelRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelRPLayout.createSequentialGroup()
                                .addComponent(PrestarRP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CancelarRP))
                            .addGroup(PanelRPLayout.createSequentialGroup()
                                .addGroup(PanelRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelRPLayout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(44, 44, 44))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRPLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)))
                                .addGroup(PanelRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FechaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(IdLP)))
                            .addGroup(PanelRPLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FechaEP))
                            .addGroup(PanelRPLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(28, 28, 28)
                                .addComponent(IdP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelRPLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(IdUP, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelRPLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelRPLayout.setVerticalGroup(
            PanelRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(IdP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdLP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrestarRP)
                    .addComponent(CancelarRP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Archivo.setText("Archivo");

        GuardarArchivo.setText("Guardar informacion");
        GuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarArchivoActionPerformed(evt);
            }
        });
        Archivo.add(GuardarArchivo);

        jMenuBar1.add(Archivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Opcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(Registrar)
                        .addGap(6, 6, 6)
                        .addComponent(Consultar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelRU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Opcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Registrar)
                    .addComponent(Consultar))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(PanelRU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pack();
	}
	
	private <E> boolean existePorId(LinkedList<E> lista, int id, java.util.function.ToIntFunction<E> idGetter) {
		for (E object : lista) {
			if (idGetter.applyAsInt(object) == id) {
				return true;
			}
		}
		return false;
	}
	
	private void GuardarRUActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			int id = Integer.parseInt(IdU.getText());
			if (existePorId(usuarios, id, Usuario::getIdUsuario)) {
				JOptionPane.showMessageDialog(null, "Ese id ya se encuentra en uso");
			} else {
	            Usuario u = new Usuario(Integer.parseInt(IdU.getText()), NombreU.getText(), ApellidoPU.getText(), ApellidoMU.getText(), DireccionU.getText(), TipoU.getSelectedIndex());
	            usuarios.add(u);
	            TextC.setText("-Usuario agregado-\n" + u.toString());
	            IdU.setText("");
	            NombreU.setText("");
	            ApellidoPU.setText("");
	            ApellidoMU.setText("");
	            DireccionU.setText("");
			}
		} catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El Id debe ser de tipo entero", "Formato de numero invalido", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
		}
	}
	
	private void CancelarRUActionPerformed(java.awt.event.ActionEvent evt) {
		PanelRU.setVisible(false);
	}
	
	private void CancelarRLActionPerformed(java.awt.event.ActionEvent evt) {
		PanelRL.setVisible(false);
	}
	
	private void CancelarRPActionPerformed(java.awt.event.ActionEvent evt) {
		PanelRP.setVisible(false);
	}
	
	private void GuardarRLActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			int id = Integer.parseInt(IdL.getText());
			if (existePorId(libros, id, Libro::getIdLibro)) {
				JOptionPane.showMessageDialog(null, "Ese id ya se encuentra en uso");
			} else {
				boolean estado = true;
				if (StatusL.getSelectedItem().equals("Ocupado")) {
					estado = false;
				}
				Libro l = new Libro(Integer.parseInt(IdL.getText()), AutorL.getText(), EdicionL.getText(), EditorialL.getText(), estado);
				libros.add(l);
				TextC.setText("-Libro agregado-\n" + l.toString());
                IdL.setText("");
                AutorL.setText("");
                EdicionL.setText("");
                EditorialL.setText("");
			}
		} catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El Id debe ser de tipo entero", "Formato de numero invalido", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
		}
	}
	
	private void PrestarRPActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			boolean banderaLibro = false;
			boolean banderaUsuario = false;
			
			for (Libro libro : libros) {
				if (libro.getIdLibro() == Integer.parseInt(IdLP.getText()) & libro.isEstatus() == true) {
					banderaLibro = true;
				}
			}
			if (existePorId(usuarios, Integer.parseInt(IdUP.getText()), Usuario::getIdUsuario)) {
				banderaUsuario = true;
			}
			
			if (banderaLibro) {
				if (banderaUsuario) {
					if (existePorId(prestamos, Integer.parseInt(IdP.getText()), Prestamo::getIdPrestamo)) {
	                    JOptionPane.showMessageDialog(null, "Ese id ya se encuentra en uso");
					} else {
						Prestamo p = new Prestamo(Integer.parseInt(IdP.getText()), Integer.parseInt(IdLP.getText()), Integer.parseInt(IdUP.getText()), FechaEP.getText(), FechaSP.getText(), libros);
		                prestamos.add(p);
		                JOptionPane.showMessageDialog(null, "Prestamo agregado");
		                TextC.setText("-Prestamo registrado-\n" + p.toString());
		                IdUP.setText("");
		                IdLP.setText("");
		                IdP.setText("");
		                FechaEP.setText("");
		                FechaSP.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, "El usuario no existe.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Libro no disponible.");
			}
		} catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El Id debe ser de tipo entero", "Formato de numero invalido", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
		}
	}
	
	private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {
		setLocationRelativeTo(null);
		
		switch (Opcion.getSelectedItem().toString()) {
		case "Usuarios": 
			setSize(680, 440);
            PanelRL.setVisible(false);
            PanelRP.setVisible(false);
            PanelRU.setVisible(true);
		break;
		case "Libros":
			setSize(615, 395);
            PanelRU.setVisible(false);
            PanelRP.setVisible(false);
            PanelRL.setVisible(true);
        break;
		case "Prestamos":
			setSize(640, 390);
            PanelRU.setVisible(false);
            PanelRL.setVisible(false);
            PanelRP.setVisible(true);
        break;
		default:
			JOptionPane.showMessageDialog(null, "Esta opcion te permite elegir que deseas registrar");
		break;
		}
	}
	
	private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {
		setLocationRelativeTo(null);
        PanelRL.setVisible(false);
        PanelRP.setVisible(false);
        PanelRU.setVisible(false);
        setSize(368, 445);
        
        switch (Opcion.getSelectedItem().toString()) {
		case "Usuarios":
			if (!usuarios.isEmpty()) {
				TextC.setText("");
				for (int i = 0; i < usuarios.size(); i++) {
					TextC.append(usuarios.get(i).toString()+"\n");
				}
			}else{
                JOptionPane.showMessageDialog(null, "No hay usuarios registrados", "Ups!", JOptionPane.ERROR_MESSAGE);
            }
		break;
		case "Libros":
			if (!libros.isEmpty()) {
				TextC.setText("");
				for(int i=0;i<libros.size();i++){
                    TextC.append(libros.get(i).toString()+"\n");
                }
			} else {
                JOptionPane.showMessageDialog(null, "No hay libros registrados", "Ups!", JOptionPane.ERROR_MESSAGE);
			}
		break;
		case "Prestamos":
			if (!prestamos.isEmpty()) {
				TextC.setText("");
                for(int i=0;i<prestamos.size();i++){
                    TextC.append(prestamos.get(i).toString()+"\n");
                }
			} else {
                JOptionPane.showMessageDialog(null, "No hay prestamos registrados", "Ups!", JOptionPane.ERROR_MESSAGE);
			}
		break;
		default:
            JOptionPane.showMessageDialog(null, "Esta opcion te permite elegir que deseas consultar");
			break;
		}
	}
	
	private void GuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {
		//Respaldando arhivo de datos
		try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(archivo))) {
			DatosBibliotecarios datos = new DatosBibliotecarios();
			datos.setUsuarios(usuarios);
			datos.setLibros(libros);
			datos.setPrestamos(prestamos);
			ois.writeObject(datos);
			JOptionPane.showMessageDialog(null, "Se ha guardado el archivo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < prestamos.size(); i++) {
            prestamos.get(i).Contador(TextC);
            if(prestamos.get(i).isBorrar()){
                prestamos.remove(i);
            }
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
	}
}