package controller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.CompAccount;
import service.ClientService;
import service.ClientServiceImp;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(name = "ClientServletBalance", value = "/account")
public class ClientServletBalance extends HttpServlet {

    private static final ClientService csi = new ClientServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()) {
            out.print(csi.showBalance(Long.parseLong(request.getParameter("acc_id"))));
            out.flush();
        } catch (IOException | NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            String jsonText = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            Gson gson = new GsonBuilder().create();
            CompAccount compAccount = gson.fromJson(jsonText, CompAccount.class);
            csi.incBalance(compAccount.getId()
                    , compAccount.getBalance());
            out.print(csi.showBalance(compAccount.getId()));
            out.flush();
        } catch (NumberFormatException | IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
