package com.example.optimizerpc.models.services.utils;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {

    private final String username = "contactojuancaa@gmail.com";
    private final String password = "hxzryxhqaiuhamds";

    public void sendEmail(String destinatario, String nombreUsuario) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(username));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject("🎉 ¡Bienvenido a OptimizerPC!");

            String htmlContent = "<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "  <style>" +
                    "    body { font-family: Arial, sans-serif; background-color: #f4f4f4; color: #333; padding: 20px; }" +
                    "    .container { background-color: #fff; border-radius: 8px; padding: 30px; box-shadow: 0 2px 6px rgba(0,0,0,0.1); }" +
                    "    h1 { color: #2c3e50; }" +
                    "    p { font-size: 16px; line-height: 1.6; }" +
                    "    .footer { margin-top: 30px; font-size: 12px; color: #888; }" +
                    "  </style>" +
                    "</head>" +
                    "<body>" +
                    "  <div class='container'>" +
                    "    <h1>👋 ¡Hola " + nombreUsuario + "!</h1>" +
                    "    <p>Gracias por registrarte en <strong>OptimizerPC</strong>, tu tienda online de confianza en servicios y productos informáticos.</p>" +
                    "    <p>Estamos encantados de tenerte como parte de nuestra comunidad. Explora nuestras categorías, añade productos a tu carrito, ¡y disfruta de una experiencia tecnológica optimizada! 🚀</p>" +
                    "    <p>Si tienes cualquier duda, puedes escribirnos directamente respondiendo a este correo. 📩</p>" +
                    "    <br>" +
                    "    <p>¡Bienvenido a bordo!</p>" +
                    "    <p>— El equipo de OptimizerPC</p>" +
                    "    <div class='footer'>" +
                    "      Este correo fue enviado automáticamente. Por favor, no lo respondas directamente si no es necesario." +
                    "    </div>" +
                    "  </div>" +
                    "</body>" +
                    "</html>";

            mensaje.setContent(htmlContent, "text/html; charset=utf-8");

            Transport.send(mensaje);
            System.out.println("✅ Correo HTML enviado correctamente a " + destinatario);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
