package utp.desarrollo;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrian Albaez
 */
public class Mensaje {

    void MensajeError(String correo) {

        String asunto = "¡Acceso bloqueado!";
        String mensaje = "Se han detectado tres intentos fallidos de inicio de sesión en su cuenta.\n";
        mensaje += "Su usuario de farmacia EGPH, ha sido bloqueado temporalmente, por motivos de seguridad.";
        String emisor = "proyectofinalutp12@gmail.com";
        String contrasena = "Proyecto123";
      
            Properties propiedad = new Properties();
            propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
            propiedad.setProperty("mail.smtp.starttls.enable", "true");
            propiedad.setProperty("mail.smtp.port", "587");
            propiedad.setProperty("mail.smtp.auth", "true");
            Session sesion = Session.getDefaultInstance(propiedad);
            MimeMessage mail = new MimeMessage(sesion);
            try {
                mail.setFrom(new InternetAddress(emisor));
                mail.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
                mail.setSubject(asunto);
                mail.setText(mensaje);

                Transport transporte = sesion.getTransport("smtp");
                transporte.connect(emisor, contrasena);
                transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
                transporte.close();
                JOptionPane.showMessageDialog(null, "Revise la bandeja de entrada de su correo");

            } catch (AddressException ex) {
                Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}
