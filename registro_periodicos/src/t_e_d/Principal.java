package t_e_d;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/*
	Objetivo: Realizar la implementación de un sistema que permita administrar la
	información de diversos periódicos de la ciudad.
	
	Los datos que se requiere almacenar para cada uno de los periódicos son: Nombre,
	tipo (que puede ser impreso o en línea, en caso de los periódicos impresos, almacenar
	el precio) y en el caso de los periódicos en linea, almacenar el top 5 de las noticias
	más leídas por día. La información que debe contener cada una de las noticias del Top
	5 es: Fecha (Factor de orden de la lista) , el encabezado de la noticia y el nombre del
	periodista.
	
	El sistema debe permitir al usuario las siguientes opciones:
	1. Importar: Carga las noticias a una lista desde un archivo.
	2. Insertar: Crea un nuevo periódico y lo inserta en la lista.
	3. Modificar: Modifica la información del periódico (Nombre, tipo) o realiza alguna
	operación en la sección Top noticias (Insertar por fecha, eliminar por fecha,
	modificar, mostrar por día, mostrar todos).
	
	4. Buscar: Muestra la información completa del periódico seleccionado.
	5. Exportar: Almacena la información completa de un periódico en un nuevo archivo.
	6. Eliminar: Elimina un periódico y toda su información de la lista.
	7. Salir: Finaliza el programa.
*/

public class Principal extends javax.swing.JFrame {
	private javax.swing.JButton Buscar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Modificar;  
    private javax.swing.JButton Insertar;
    private javax.swing.JLabel EncaL;
    private javax.swing.JLabel FechaL;
    private javax.swing.JLabel NamePL;
    private javax.swing.JLabel Periodico;
    private javax.swing.JLabel Precio;
    private javax.swing.JLabel PrecioL;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton Impreso;
    private javax.swing.JRadioButton Linea;
    private javax.swing.JTextArea Respuesta;
    private javax.swing.JTextField TextEnca;
    private javax.swing.JTextField TextFecha;
    private javax.swing.JTextField TextNameP;
    private javax.swing.JTextField TextPeriodico;
    private javax.swing.JTextField TextPrecio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;  
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
	
	public Principal() {
		initComponents();
		Linea.setSelected(true);
		PrecioL.setVisible(false);
		TextPrecio.setVisible(false);
		Respuesta.setEditable(false);
	}
	
	final String archivo = "Archpe.txt";
	LinkedList<Periodico> lista = new LinkedList<>();
	
	private void initComponents() {
		buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Periodico = new javax.swing.JLabel();
        TextPeriodico = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Linea = new javax.swing.JRadioButton();
        Impreso = new javax.swing.JRadioButton();
        Precio = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        NamePL = new javax.swing.JLabel();
        FechaL = new javax.swing.JLabel();
        EncaL = new javax.swing.JLabel();
        TextNameP = new javax.swing.JTextField();
        TextFecha = new javax.swing.JTextField();
        TextEnca = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Insertar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Respuesta = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        PrecioL = new javax.swing.JLabel();
        TextPrecio = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        
        jMenuItem1.setText("jMenuItem1");
        jMenuItem2.setText("jMenuItem2");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        Periodico.setText("Nombre del periodico: ");
        
        jLabel2.setText("Tipo de periodico:");

        buttonGroup1.add(Linea);
        Linea.setText("En linea");
        Linea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineaActionPerformed(evt);
            }
        });

        buttonGroup1.add(Impreso);
        Impreso.setText("Impreso");
        Impreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImpresoActionPerformed(evt);
            }
        });
        
        NamePL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NamePL.setText("Nombre del periodista:");
        FechaL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        FechaL.setText("Fecha:");
        EncaL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        EncaL.setText("Encabezado:");
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NamePL, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(FechaL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EncaL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(TextEnca)
                    .addComponent(TextNameP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NamePL)
                    .addComponent(TextNameP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EncaL)
                    .addComponent(TextEnca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaL)
                    .addComponent(TextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        
        Insertar.setText("Insertar");
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });
        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Insertar)
                    .addComponent(Modificar)
                    .addComponent(Buscar)
                    .addComponent(Eliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        Respuesta.setColumns(20);
        Respuesta.setRows(5);
        jScrollPane1.setViewportView(Respuesta);
        
        PrecioL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PrecioL.setText("Precio del periodico");
        
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PrecioL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextPrecio))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PrecioL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        jMenu1.setText("Opciones de Archivo");
        jMenuItem3.setText("Exportar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenuItem4.setText("Importar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenuBar1.add(jMenu1);
        setJMenuBar(jMenuBar1);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Periodico, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Linea)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Impreso)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(TextPeriodico)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Precio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Periodico, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextPeriodico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Linea)
                    .addComponent(Impreso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Precio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        pack();
        setLocationRelativeTo(null);
	}
	
	private void LineaActionPerformed(java.awt.event.ActionEvent evt) {
		if (Linea.isSelected()) {
			PrecioL.setVisible(false);
			TextPrecio.setVisible(false);
			NamePL.setVisible(true);
			EncaL.setVisible(true);
			FechaL.setVisible(true);
			TextNameP.setVisible(true);
			TextEnca.setVisible(true);
			TextFecha.setVisible(true);
		}
	}
	
	private void ImpresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImpresoActionPerformed
        if (Impreso.isSelected()) {
            PrecioL.setVisible(true);
            TextPrecio.setVisible(true);
            NamePL.setVisible(false);
            EncaL.setVisible(false);
            FechaL.setVisible(false);
            TextNameP.setVisible(false);
            TextEnca.setVisible(false);
            TextFecha.setVisible(false);
        }
    }
	
	private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {
		if (Linea.isSelected()) {
			String nombre, nomp, enca, fecha;
			nombre = TextPeriodico.getText();
			nomp = TextNameP.getText();
			enca = TextEnca.getText();
			fecha = TextFecha.getText();
			int posicion = -1;
			boolean nuevaFecha = true;
			
			for (int i = 0; i < lista.size(); i++) {
				//Comprobar si es en linea y se llaman igual
				if (lista.get(i).getNombre().equalsIgnoreCase(nombre) && lista.get(i).getTipo().equals("Linea")) {
					posicion = i;
					
					//Comprobacion de si existe la fecha en el periódico
					if (((Linea) lista.get(i)).existeFecha(fecha)) {
						nuevaFecha = false;
					}
				}
			}
			Linea l;
			// No existe un periódico con ese nombre
			if(posicion == -1) {
				l = new Linea(nombre, "Linea");
				Fecha aux = new Fecha(fecha);
				Noticia n = new Noticia(nomp, enca, fecha);
				aux.addNoticia(n);
				l.addFecha(aux);
				lista.add(l);
                Respuesta.append("En línea - Nuevo periódico agregado\n");
			} else {
				l = (Linea) lista.get(posicion);
				// Si es una nueva fecha
				if (nuevaFecha) {
					Fecha aux = new Fecha(fecha);
					Noticia n = new Noticia(nomp, enca, fecha);
					aux.addNoticia(n);
					l.addFecha(aux);
					Respuesta.append("En línea - Nueva fecha agregada\n");
				}else {
					LinkedList<Fecha> fechas = ((Linea) lista.get(posicion)).getFechas();
					Noticia n = new Noticia(nomp, enca, fecha);
					for (int i = 0; i < fechas.size(); i++) {
						if (((Fecha) fechas.get(i)).sizeNoticias() != 5) {
							if (fechas.get(i).getFecha().equals(fecha)) {
								fechas.get(i).addNoticia(n);
								Respuesta.append("En línea - Nueva noticia agregada\\n");
								break;
							}
						} else {
							Respuesta.append("En línea - TOP 5 lleno\n");
						}
					}
				}
			}
		} else if (Impreso.isSelected()) {
			String nombre;
			int precio;
			nombre = TextPeriodico.getText();
			precio = Integer.parseInt(TextPrecio.getText());
			Impreso m = new Impreso(precio, nombre, "Impreso");
			lista.add(m);
			Respuesta.append("Impreso - Agregado con éxito\n");
		}
	}
	
	private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed

    }
	
	private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {
		if (lista.isEmpty()) {
			JOptionPane.showInputDialog("Nombre del periodico: ");
		} else {
			Respuesta.setText("");
			boolean encon = false;
			String nombre = JOptionPane.showInputDialog("Nombre del periodico: ");
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
					Respuesta.append("Se ha eliminado el periódico:\n");
					Respuesta.append(lista.get(i).toString());
					lista.remove(i);
					encon = true;
					break;
				}
			}
			if (encon == false) {
				JOptionPane.showMessageDialog(null, "No se encontro", "Ups!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {
		if (!lista.isEmpty()) {
			Respuesta.setText("");
			String nombre = JOptionPane.showInputDialog("Nombre del periodico: ");
			boolean encon = false;
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
					Respuesta.append(lista.get(i).toString());
					encon = true;
				}
			}
			if (!encon) {
				JOptionPane.showMessageDialog(null, "No se encontro", "Ups!", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay periodicos", "Ups!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
		try(FileOutputStream is = new FileOutputStream(archivo);
			ObjectOutputStream ois = new ObjectOutputStream(is);) {
			ois.writeObject(lista);
            JOptionPane.showMessageDialog(null, "Se ha guardado el archivo");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
		}
	}
	
	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			InputStream is = new FileInputStream(archivo);
			ObjectInputStream ois = new ObjectInputStream(is);
			
			Object obj = ois.readObject();
			if (obj instanceof LinkedList<?>) {
				lista = (LinkedList<Periodico>) obj;
				JOptionPane.showMessageDialog(null, "Se ha recuperado el archivo");
			} else {
				JOptionPane.showMessageDialog(null, "El archivo no contiene datos válidos");
			}
			ois.close();
			is.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
     * @param args the command line arguments
     */
	public static void main(String args[]) {
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
		
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
	}
}