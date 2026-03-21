package org.uycode.interviews;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.Executor;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 14/03/2026 13:39:31
 *
 */

public class MiniServer extends HttpServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080, 1, InetAddress.getByAddress(new byte[]{0, 0, 0, 0}));
            serverSocket.accept();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void bind(InetSocketAddress addr, int backlog) throws IOException {

    }

    @Override
    public void start() {

    }

    @Override
    public void setExecutor(Executor executor) {

    }

    @Override
    public Executor getExecutor() {
        return null;
    }

    @Override
    public void stop(int delay) {

    }

    @Override
    public HttpContext createContext(String path, HttpHandler handler) {
        return null;
    }

    @Override
    public HttpContext createContext(String path) {
        return null;
    }

    @Override
    public void removeContext(String path) throws IllegalArgumentException {

    }

    @Override
    public void removeContext(HttpContext context) {

    }

    @Override
    public InetSocketAddress getAddress() {
        return null;
    }
}
