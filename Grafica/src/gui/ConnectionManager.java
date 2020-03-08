package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionManager implements Runnable {

	private Socket socket;

	private BufferedReader br;

	private PrintWriter pw;

	private MainFrame mainFrame;

	public ConnectionManager(Socket socket, String name, MainFrame mainFrame) {

		this.socket = socket;
		this.mainFrame = mainFrame;

		mainFrame.gamePanel.protagonista = name;
	}

	public void setup() throws IOException {
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream(), true);

	}

	public void dispatch(String message) {

		pw.println(message);
	}

	@Override
	public void run() {
		try {

			String buffer = "NON START";
			boolean start = false;

			buffer = br.readLine();
			while (!start) {

				if (buffer.equals("START")) {

					buffer = br.readLine();

					mainFrame.mondo.parseStartMapStatusFromString(buffer);

					start = true;
					mainFrame.showGameNetwork();

				}

				buffer = br.readLine();
			}

			while (buffer != null) {

				String[] split = buffer.split(":");

				if (buffer.equals("GAME OVER")) {
					mainFrame.gamePanel.stopGame();
					socket.close();
				} else if (split[0].equals("SPARO"))
					mainFrame.gamePanel.soundSparo(Integer.parseInt(split[1]));
				else
					mainFrame.mondo.parseStatusFromString(buffer);

				String mossa = mainFrame.gamePanel.gestoreEventi();

				dispatch(mossa);
				mainFrame.gamePanel.update();

				mainFrame.gamePanel.repaint();
				buffer = br.readLine();

			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Connection Close");
		}
	}

}
