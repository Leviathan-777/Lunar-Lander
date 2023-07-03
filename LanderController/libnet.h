/* Network and UDP Library
 * KV5002
 *
 * Dr Alun Moon
 */
int getaddr(const char *node, const char *service, struct addrinfo **address);

int mksocket(void);

int bindsocket(int sfd, const struct sockaddr *addr, socklen_t addrlen);

char *addrtouri(struct sockaddr *addr);

typedef size_t (*handler_t)(char *, size_t, char *, size_t, struct sockaddr_in *);

int server(int srvrsock, handler_t handlemsg);

extern int cleanupsock;

void finished(int signal);

void cleanup(void);

