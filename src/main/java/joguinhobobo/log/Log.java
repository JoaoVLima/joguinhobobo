package joguinhobobo.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Log {

    private static final String LOG_FILE = "log_jogo.txt";

    private static final DateTimeFormatter FORMATADOR =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss",
                    new Locale("pt", "BR"));

    public static void append(String mensagem) {
        String dataHora = LocalDateTime.now().format(FORMATADOR);
        try (BufferedWriter w = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            w.write(dataHora + " " + mensagem);
            w.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}