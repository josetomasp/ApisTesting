package automation_frontend.utils.enums.CardTypes;

public enum ECardTypes {

    SUBE {
        @Override
        public String toString() {
            return "SUBE";
        }
    },
    METROPOLITANA {
        @Override
        public String toString() {
            return "METROPOLITANA";
        }
    },
    CIUDADANA {
        @Override
        public String toString() {
            return "CIUDADANA";
        }
    },
    SALTA {
        @Override
        public String toString() { return "Salta";        }
    },
    MENDOZA {
        @Override
        public String toString() { return "Mendoza";        }
    },
    CORDOBA {
        @Override
        public String toString() { return "Córdoba";        }
    }
}