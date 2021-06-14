public class Less5_2 {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {
            try (RobotConnection connect = robotConnectionManager.getConnection()) {
                connect.moveRobotTo(toX, toY);
                if (connect != null) {
                    i = 3;
                }
            } catch (RobotConnectionException et) {
                if (i == 2) {
                    throw new RobotConnectionException("3");
                }

            } catch (Throwable e) {
                throw e;
            }
        }


    }

    public static class RobotConnectionManagerImplementation implements Less5_1.RobotConnectionManager {
        private int throwNumberMove;
        private int throwNumberClose;
        private boolean isException;
        private int connectionAttempt;
        private int curCA = 0;
        private int curNM = 0;
        private int curNC = 0;

        public RobotConnectionManagerImplementation(int tnm, int tnc, boolean ie, int ca) {
            throwNumberMove = tnm;
            throwNumberClose = tnc;
            isException = ie;
            connectionAttempt = ca;
        }

        @Override
        public Less5_1.RobotConnection getConnection() {
            if (curCA < connectionAttempt) {
                curCA++;
                throw new Less5_1.RobotConnectionException("CONNECTION EXCEPTION");
            }
            boolean isTC = false;
            boolean isTM = false;
            if (curNC < throwNumberClose) {
                isTC = true;
                curNC++;
            }

            if (curNM < throwNumberMove) {
                isTM = true;
                curNM++;
            }
            Less5_1.RobotConnection rc = new Less5_1.Robot(0, 0, Less5_1.Direction.DOWN, isTM, isTC, isException);
            return rc;
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot implements Less5_1.RobotConnection {
        int x;
        int y;
        Less5_1.Direction dir;
        boolean isthrowMove;
        boolean isthrowClose;
        boolean isthrowException;


        public void close() {
            if (isthrowClose) {
                throw new Less5_1.RobotConnectionException("CLOSE EXCEPTION");
            }
        }

        public Robot(int x, int y, Less5_1.Direction dir, boolean itm, boolean itc, boolean ite) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            isthrowMove = itm;
            isthrowClose = itc;
            isthrowException = ite;
        }

        public Less5_1.Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Less5_1.Direction.UP) {
                dir = Less5_1.Direction.LEFT;
            } else if (dir == Less5_1.Direction.DOWN) {
                dir = Less5_1.Direction.RIGHT;
            } else if (dir == Less5_1.Direction.LEFT) {
                dir = Less5_1.Direction.DOWN;
            } else if (dir == Less5_1.Direction.RIGHT) {
                dir = Less5_1.Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Less5_1.Direction.UP) {
                dir = Less5_1.Direction.RIGHT;
            } else if (dir == Less5_1.Direction.DOWN) {
                dir = Less5_1.Direction.LEFT;
            } else if (dir == Less5_1.Direction.LEFT) {
                dir = Less5_1.Direction.UP;
            } else if (dir == Less5_1.Direction.RIGHT) {
                dir = Less5_1.Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Less5_1.Direction.UP) {
                y++;
            }
            if (dir == Less5_1.Direction.DOWN) {
                y--;
            }
            if (dir == Less5_1.Direction.LEFT) {
                x--;
            }
            if (dir == Less5_1.Direction.RIGHT) {
                x++;
            }
        }

        public void moveRobotTo(int toX, int toY) {
            int dx = toX - getX();
            int dy = toY - getY();

            Less5_1.Direction needX = Less5_1.Direction.RIGHT;
            if (dx < 0) {
                needX = Less5_1.Direction.LEFT;
            }
            while (getDirection() != needX) {
                turnRight();
            }

            for (dx = Math.abs(dx); dx > 0; dx--) {
                stepForward();
            }

            Less5_1.Direction needY = Less5_1.Direction.UP;
            if (dy < 0) {
                needY = Less5_1.Direction.DOWN;
            }
            while (getDirection() != needY) {
                turnRight();
            }

            for (dy = Math.abs(dy); dy > 0; dy--) {
                stepForward();
            }

            if (isthrowException) {
                throw new NullPointerException("ANOTHER EXCEPTION");
            }

            if (isthrowMove) {
                throw new Less5_1.RobotConnectionException("MOVE EXCEPTION");
            }
        }
    }

    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);

        @Override
        void close();
    }

    public interface RobotConnectionManager {
        Less5_1.RobotConnection getConnection();
    }

    public static class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void main(String[] args) {
        try {
            Less5_1.RobotConnectionManagerImplementation rcm = new Less5_1.RobotConnectionManagerImplementation(3, 3, false, 1);
            moveRobot(rcm, 2, 2);
        } catch (Exception r) {
            System.out.println("TEST #1 " + ((r.getMessage() == "MOVE EXCEPTION") ? "PASS" : "FAILED WITH " + r.getMessage()));
        }

        try {
            Less5_1.RobotConnectionManagerImplementation rcm = new Less5_1.RobotConnectionManagerImplementation(0, 0, false, 0);
            moveRobot(rcm, 2, 2);
            System.out.println("TEST #2 PASS");
        } catch (Less5_1.RobotConnectionException r) {
            System.out.println("TEST #2 FAILED WITH " + r.getMessage());
        }

        try {
            Less5_1.RobotConnectionManagerImplementation rcm = new Less5_1.RobotConnectionManagerImplementation(2, 0, false, 0);
            moveRobot(rcm, 2, 2);
            System.out.println("TEST #3 PASS");
        } catch (Exception r) {
            System.out.println("TEST #3 FAILED WITH " + r.getMessage());
        }

        try {
            Less5_1.RobotConnectionManagerImplementation rcm = new Less5_1.RobotConnectionManagerImplementation(3, 0, false, 0);
            moveRobot(rcm, 2, 2);
        } catch (Exception r) {
            System.out.println("TEST #4 " + ((r.getMessage() == "MOVE EXCEPTION") ? "PASS" : "FAILED WITH " + r.getMessage()));
        }

        try {
            Less5_1.RobotConnectionManagerImplementation rcm = new Less5_1.RobotConnectionManagerImplementation(3, 0, true, 0);
            moveRobot(rcm, 2, 2);
        } catch (Exception r) {
            System.out.println("TEST #5 " + ((r.getMessage() == "ANOTHER EXCEPTION") ? "PASS" : "FAILED WITH " + r.getMessage()));
        }

        try {
            Less5_1.RobotConnectionManagerImplementation rcm = new Less5_1.RobotConnectionManagerImplementation(2, 5, false, 0);
            moveRobot(rcm, 2, 2);
            System.out.println("TEST #6 PASS");
        } catch (Exception r) {
            System.out.println("TEST #6 FAILED WITH " + r.getMessage());
        }

        try {
            Less5_1.RobotConnectionManagerImplementation rcm = new Less5_1.RobotConnectionManagerImplementation(0, 5, false, 2);
            moveRobot(rcm, 2, 2);
            System.out.println("TEST #7 PASS");
        } catch (Exception r) {
            System.out.println("TEST #7 FAILED WITH " + r.getMessage());
        }

        try {
            Less5_1.RobotConnectionManagerImplementation rcm = new Less5_1.RobotConnectionManagerImplementation(1, 0, false, 2);
            moveRobot(rcm, 2, 2);
        } catch (Exception r) {
            System.out.println("TEST #8 " + ((r.getMessage() == "MOVE EXCEPTION") ? "PASS" : "FAILED WITH " + r.getMessage()));
        }
    }
}
