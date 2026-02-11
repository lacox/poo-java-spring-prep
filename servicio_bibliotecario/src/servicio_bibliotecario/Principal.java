package servicio_bibliotecario;

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ServicioBibliotecario sb = new ServicioBibliotecario();
	
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JMenu menuLibros;
    private javax.swing.JMenu menuPrestamos;
    private javax.swing.JMenu menuSalidas;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem menuItemUR;
    private javax.swing.JMenuItem menuItemUC;
    private javax.swing.JMenuItem menuItemUM;
    private javax.swing.JMenuItem menuItemLR;
    private javax.swing.JMenuItem menuItemLC;
    private javax.swing.JMenuItem menuItemLM;
    private javax.swing.JMenuItem menuItemPR;
    private javax.swing.JMenuItem menuItemPC;
    private javax.swing.JMenuItem menuItemPM;
    private javax.swing.JMenuItem menuItemSR;
    private javax.swing.JMenuItem menuItemSS;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea registros;

	public Principal() {
		initComponents();
		sb.cargarLibros();
		sb.cargarUsuarios();
        JOptionPane.showMessageDialog(null, "Datos cargados al sistema.");
	}
	
	private void initComponents() {
		jScrollPane1 = new javax.swing.JScrollPane();
        registros = new javax.swing.JTextArea();
        
		jMenuBar = new javax.swing.JMenuBar();
		
        menuUsuarios = new javax.swing.JMenu();
		menuItemUR = new javax.swing.JMenuItem();
		menuItemUC = new javax.swing.JMenuItem();
		menuItemUM = new javax.swing.JMenuItem();
		
		menuLibros = new javax.swing.JMenu();
		menuItemLR = new javax.swing.JMenuItem();
		menuItemLC = new javax.swing.JMenuItem();
		menuItemLM = new javax.swing.JMenuItem();
		
        menuPrestamos = new javax.swing.JMenu();
        menuItemPR = new javax.swing.JMenuItem();
        menuItemPC = new javax.swing.JMenuItem();
        menuItemPM = new javax.swing.JMenuItem();
        
        menuSalidas = new javax.swing.JMenu();
        menuItemSR = new javax.swing.JMenuItem();
        menuItemSS = new javax.swing.JMenuItem();
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        registros.setColumns(20);
        registros.setRows(5);
        jScrollPane1.setViewportView(registros);

        menuUsuarios.setText("Usuarios"); /// <------

        menuItemUR.setText("Registro");
        menuItemUR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuItemURActionPerformed(evt);
            }
        });
        menuUsuarios.add(menuItemUR);

        menuItemUC.setText("Consulta");
        menuItemUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuItemUCActionPerformed(evt);
            }
        });
        menuUsuarios.add(menuItemUC);
        
        menuItemUM.setText("Modificacion");
        // Falta metodo???
        menuUsuarios.add(menuItemUM);
        
        jMenuBar.add(menuUsuarios);

        menuLibros.setText("Libros"); /// <------

        menuItemLR.setText("Registro");
        menuItemLR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuItemLRActionPerformed(evt);
            }
        });
        menuLibros.add(menuItemLR);

        menuItemLC.setText("Consulta");
        menuItemLC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuItemLCActionPerformed(evt);
            }
        });
        menuLibros.add(menuItemLC);

        menuItemLM.setText("Modificacion");
        // Falta metodo
        menuLibros.add(menuItemLM);
        
        jMenuBar.add(menuLibros);

        menuPrestamos.setText("Prestamos");

        menuItemPR.setText("Registro");
        menuItemPR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuItemPRActionPerformed(evt);
            }
        });
        menuPrestamos.add(menuItemPR);

        menuItemPC.setText("Consulta");
        menuItemPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuItemPCActionPerformed(evt);
            }
        });
        menuPrestamos.add(menuItemPC);
        
        menuItemPM.setText("Modificacion");
        // Falta metodo???
        menuPrestamos.add(menuItemPM);

        jMenuBar.add(menuPrestamos);

        menuSalidas.setText("Salir");
        
        menuItemSS.setText("Salir sin guardar");
        menuItemSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuItemSSActionPerformed(evt);
            }
        });
        menuSalidas.add(menuItemSS);

        menuItemSR.setText("Respaldar datos");
        menuItemSR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuItemSRActionPerformed(evt);
            }
        });
        menuSalidas.add(menuItemSR);

        jMenuBar.add(menuSalidas);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            	)
        );
        pack();
	}
	
	private void menuItemPRActionPerformed(java.awt.event.ActionEvent evt) {
		IPrestamos ip = new IPrestamos(sb.usuarios, sb.libros, sb.prestamos);
		ip.setVisible(true);
	}
	
	private void menuItemURActionPerformed(java.awt.event.ActionEvent evt) {
		IUsuario iu = new IUsuario(sb.usuarios);
		iu.setVisible(true);
	}
	
	private void menuItemLRActionPerformed(java.awt.event.ActionEvent evt) {
		ILibro il = new ILibro(sb.libros);
		il.setVisible(true);
	}
	
	private void menuItemPCActionPerformed(java.awt.event.ActionEvent evt) {
		registros.setText(sb.prestamos.toString());
	}
	
	private void menuItemUCActionPerformed(java.awt.event.ActionEvent evt) {
		registros.setText(sb.usuarios.toString());
	}
	
	private void menuItemLCActionPerformed(java.awt.event.ActionEvent evt) {
		registros.setText(sb.libros.toString());
	}
	
	// Faltan metodos de modificacion ??? 
	
	private void menuItemSRActionPerformed(java.awt.event.ActionEvent evt) {
		FileWriter archivo = null;
		PrintWriter pw = null;
		//Respaldando libros
		try {
			archivo = new FileWriter("libros.txt");
			pw = new PrintWriter(archivo);
			for (Libro lib : sb.libros) {
				pw.println(lib.getIdLibro());
                pw.println("disponible");
                pw.println(lib.getEdicion());
                pw.println(lib.getAutor());
                pw.println(lib.getEditorial());
			}
            JOptionPane.showMessageDialog(null, "Libros respaldados correctamente en libros.txt.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (archivo != null) {
					archivo.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		//Respaldando usuarios
		archivo = null;
		pw = null;
		
		try {
			archivo = new FileWriter("usuarios.txt");
			pw = new PrintWriter(archivo);
			for (Usuario  us : sb.usuarios) {
				pw.println(us.getIdUsuario());
                pw.println(us.getNombre());
                pw.println(us.getApellidoP());
                pw.println(us.getApellidoM());
                pw.println(us.getDireccion());
                pw.println(us.getTipoUsuario());
			}
            JOptionPane.showMessageDialog(null, "Usuarios respaldados correctamente en usuarios.txt.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (archivo != null) {
					archivo.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		dispose();
	}
	
	private void menuItemSSActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
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