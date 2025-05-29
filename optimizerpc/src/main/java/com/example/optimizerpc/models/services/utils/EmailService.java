package com.example.optimizerpc.models.services.utils;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    public void sendPurchaseConfirmation(String destinatario, String nombreUsuario, String idCompra, Date fechaCompra, Double precioTotal) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(username));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject("🎉 ¡Gracias por tu compra en OptimizerPC!");

            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");

            String htmlContent = "<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "  <style>" +
                    "    body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f9fafb; color: #333; padding: 20px; }" +
                    "    .container { background-color: #ffffff; border-radius: 10px; padding: 40px; max-width: 600px; margin: auto; box-shadow: 0 4px 12px rgba(0,0,0,0.1); }" +
                    "    h1 { color: #2d3748; }" +
                    "    p { font-size: 16px; line-height: 1.6; margin-bottom: 20px; }" +
                    "    .highlight { color: #3182ce; font-weight: bold; }" +
                    "    .details { background-color: #edf2f7; padding: 20px; border-radius: 8px; margin-bottom: 30px; }" +
                    "    .footer { font-size: 12px; color: #a0aec0; text-align: center; margin-top: 40px; }" +
                    "    .button { display: inline-block; background-color: #3182ce; color: white; padding: 12px 24px; border-radius: 6px; text-decoration: none; font-weight: bold; }" +
                    "    .button:hover { background-color: #2b6cb0; }" +
                    "  </style>" +
                    "</head>" +
                    "<body>" +
                    "  <div class='container'>" +
                    "    <h1>🎉 ¡Gracias por tu compra, " + nombreUsuario + "!</h1>" +
                    "    <p>Hemos recibido tu pedido y estamos preparando todo para que te llegue lo antes posible.</p>" +
                    "    <div class='details'>" +
                    "      <p><span class='highlight'>ID de la compra:</span> " + idCompra + "</p>" +
                    "      <p><span class='highlight'>Fecha:</span> " + sdf.format(fechaCompra) + "</p>" +
                    "      <p><span class='highlight'>Total pagado:</span> $" + String.format("%.2f", precioTotal) + "</p>" +
                    "    </div>" +
                    "    <p>Si tienes alguna pregunta o necesitas asistencia, no dudes en contactarnos respondiendo a este correo.</p>" +
                    "    <p>¡Esperamos que disfrutes de tu compra!</p>" +
                    "    <a href='https://optimizerpc.com/mis-compras' class='button'>Ver mis compras</a>" +
                    "    <div class='footer'>" +
                    "      Este correo fue enviado automáticamente. Por favor, no lo respondas si no es necesario." +
                    "    </div>" +
                    "  </div>" +
                    "</body>" +
                    "</html>";

            mensaje.setContent(htmlContent, "text/html; charset=utf-8");

            Transport.send(mensaje);
            System.out.println("✅ Correo de confirmación de compra enviado correctamente a " + destinatario);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
