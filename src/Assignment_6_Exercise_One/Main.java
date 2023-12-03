package Assignment_6_Exercise_One;
import java.util.Scanner;


interface SupportHandler {
    void handleRequest(SupportRequest request);
}


class RebootRouterHandler implements SupportHandler {
    private SupportHandler next_handler;

    public void setNextHandler(SupportHandler next_handler) {
        this.next_handler = next_handler;
    }

    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getType().equals("Reboot")) {
            System.out.println("Your problem has been fixed! Solution: Rebooting the router");
        } else if (next_handler != null) {
            next_handler.handleRequest(request);
        } else {
            System.out.println("Sorry, we couldn't resolve your issue. Please contact again.");
        }
    }
}

class FactoryResetRouterHandler implements SupportHandler {
    private SupportHandler next_handler;

    public void setNextHandler(SupportHandler next_handler) {
        this.next_handler = next_handler;
    }

    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getType().equals("Reset")) {
            System.out.println("Your problem has been fixed! Solution: Factory reset");
        } else if (next_handler != null) {
            next_handler.handleRequest(request);
        } else {
            System.out.println("Sorry, we couldn't resolve your issue. Please contact again.");
        }
    }
}

class CallCenterHandler implements SupportHandler {
    private SupportHandler next_handler;

    public void setNextHandler(SupportHandler next_handler) {
        this.next_handler = next_handler;
    }

    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getType().equals("Call")) {
            System.out.println("Your problem has been fixed! Solution: Calling the support center");
        } else if (next_handler != null) {
            next_handler.handleRequest(request);
        } else {
            System.out.println("Sorry, we couldn't resolve your issue. Please contact again.");
        }
    }
}


class SupportRequest {
    private String type;

    public SupportRequest(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

public class Main {
    public static void main(String[] args) {
        RebootRouterHandler reboot = new RebootRouterHandler();
        FactoryResetRouterHandler rename = new FactoryResetRouterHandler();
        CallCenterHandler call_center = new CallCenterHandler();


        reboot.setNextHandler(rename);
        rename.setNextHandler(call_center);

        Scanner input = new Scanner(System.in);

        System.out.println("Hello! I am a bot. Before calling the operator, please try rebooting your router. Did it help you?");
        String answer = input.next();

        SupportRequest request = null;

        if (answer.equalsIgnoreCase("yes")) {
            request = new SupportRequest("Reboot");
        } else if (answer.equalsIgnoreCase("no")) {
            System.out.println("Okay, please try resetting your router settings. Did it work?");
            answer = input.next();

            if (answer.equalsIgnoreCase("yes")) {
                request = new SupportRequest("Reset");
            } else if (answer.equalsIgnoreCase("no")) {
                System.out.println("Okay, I am linking you to the operator. Did calling help you?");
                answer = input.next();

                if (answer.equalsIgnoreCase("yes")) {
                    request = new SupportRequest("Call");
                }
            }
        }

        if (request != null) {
            reboot.handleRequest(request);
        }
    }
}








