package homeworkLesson06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BigTextServlet extends HttpServlet {
	private TextGenerator textGenerator;
	private String text;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		textGenerator = new TextGenerator();
		text = textGenerator.generateBigText();
		out.write(text);
	}

}
