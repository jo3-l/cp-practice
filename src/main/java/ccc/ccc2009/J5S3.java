package ccc.ccc2009;

import java.util.*;

public class J5S3 {
    private static Map<Integer, User> users = new HashMap<>();

    public static void main(String[] args) {
        init();

        Scanner sc = new Scanner(System.in);
        char op = sc.nextLine().charAt(0);
        while (op != 'q') {
            handleOp: switch (op) {
                case 'i': {
                    int id0 = Integer.parseInt(sc.nextLine());
                    int id1 = Integer.parseInt(sc.nextLine());

                    User user = users.computeIfAbsent(id0, k -> new User(id0));
                    users.putIfAbsent(id1, new User(id1));
                    user.addFriend(id1);
                    break;
                }
                case 'd': {
                    int id0 = Integer.parseInt(sc.nextLine());
                    int id1 = Integer.parseInt(sc.nextLine());

                    users.get(id0).removeFriend(id1);
                    break;
                }
                case 'n': {
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println(users.get(id).friends.size());
                    break;
                }
                case 'f': {
                    int id = Integer.parseInt(sc.nextLine());
                    User user = users.get(id);

                    Set<Integer> directFriends = new HashSet<>(user.friends);
                    directFriends.add(user.id);

                    Set<Integer> friendsOfFriends = new HashSet<>();
                    for (int friendId : user.friends) {
                        User friend = users.get(friendId);
                        for (int friendOfFriendId : friend.friends) {
                            if (directFriends.contains(friendOfFriendId)) continue;
                            friendsOfFriends.add(friendOfFriendId);
                        }
                    }
                    System.out.println(friendsOfFriends.size());
                    break;
                }
                case 's': {
                    int id0 = Integer.parseInt(sc.nextLine());
                    int id1 = Integer.parseInt(sc.nextLine());

                    Queue<User> q = new ArrayDeque<>();
                    Set<Integer> seen = new HashSet<>();
                    q.add(users.get(id0));
                    seen.add(id0);

                    int degree = 1;
                    while (!q.isEmpty()) {
                        int size = q.size();
                        while (size-- > 0) {
                            User user = q.poll();
                            for (int friendId : user.friends) {
                                if (seen.contains(friendId)) continue;
                                if (friendId == id1) {
                                    System.out.println(degree);
                                    break handleOp;
                                }

                                q.offer(users.get(friendId));
                                seen.add(friendId);
                            }
                        }

                        degree++;
                    }

                    System.out.println("Not connected");
                    break;
                }
            }

            op = sc.nextLine().charAt(0);
        }
    }

    private static void init() {
        // first element = user ID, next elements -> friend ID
        int[][] relations = {
                {1, 6},
                {2, 6},
                {3, 4, 15, 5, 6},
                {4, 3, 5, 6},
                {5, 6, 4, 3},
                {6, 2, 1, 3, 4, 5, 7},
                {7, 6, 8},
                {8, 7, 9},
                {9, 10, 12, 8},
                {10, 11, 9},
                {11, 12, 10},
                {12, 9, 11, 13},
                {13, 15, 12, 14},
                {14, 13},
                {15, 3, 13},
                {16, 18, 17},
                {17, 18, 16},
                {18, 16, 17},
        };
        for (int[] r : relations) {
            User user = users.computeIfAbsent(r[0], k -> new User(r[0]));
            for (int i = 1; i < r.length; i++) {
                users.putIfAbsent(r[i], new User(r[i]));
                user.addFriend(r[i]);
            }
        }
    }

    public static class User {
        public final int id;
        public final Set<Integer> friends = new HashSet<>();

        public User(int id) {
            this.id = id;
        }

        public void addFriend(int friendId) {
            friends.add(friendId);
            users.get(friendId).friends.add(id);
        }

        public void removeFriend(int friendId) {
            friends.remove(friendId);
            users.get(friendId).friends.remove(id);
        }
    }
}
