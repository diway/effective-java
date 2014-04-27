package com.diway.ServiceProviderFramework;

public class Test {
    public static void main(String[] args) {
        Services.registerDefaultProvider(DEFAULT_PROVIDER);
        Services.registerProvider("good", GOOD_PROVIDER);
        Services.registerProvider("bad", BAD_PROVIDER);

        for (Service s : new Service[]{Services.newInstance(), Services.newInstance("good"), Services.newInstance("bad")}) {
            System.out.println(s);
        }
    }

    private static Provider DEFAULT_PROVIDER = new Provider() {
        @Override
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Default service";
                }
            };
        }
    };

    private static Provider GOOD_PROVIDER = new Provider() {
        @Override
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Good service";
                }
            };
        }
    };

    private static Provider BAD_PROVIDER = new Provider() {
        @Override
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Bad service";
                }
            };
        }
    };
}
