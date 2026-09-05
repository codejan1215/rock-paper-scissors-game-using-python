section .text
    global _start

_start:
    mov rax, ST(5)
    mov rbx, ST(3)
    add rax, rbx

    mov rdi, rax
    mov rax, 60
    syscall