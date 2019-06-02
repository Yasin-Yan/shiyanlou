package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

    // ������ "/login" ����
    private static final String[] IGNORE_URI = { "/login" };

    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception exception)
            throws Exception {
        System.out.println("This is afterCompletion!");

    }

    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler, ModelAndView mv)
            throws Exception {
        System.out.println("This is postHandle!");

    }

    // �÷������� Controller ����ǰ���е���
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        System.out.println("This is preHandle!");
        // flag ��ʾ�Ƿ��¼
        boolean flag = false;
        // ��ȡ����� URL
        String url = request.getServletPath();
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            // ��ȡ Session ���ж��Ƿ��¼ 
            String username = (String) request.getSession().getAttribute(
                    "username");
            if (username == null) {
                request.setAttribute("message", "Please log in first!");
                // ���δ��¼���������أ���ת����¼����
                request.getRequestDispatcher("/WEB-INF/views/loginform.jsp")
                        .forward(request, response);
            } else {
                flag = true;
            }
        }
        return flag;
    }

}