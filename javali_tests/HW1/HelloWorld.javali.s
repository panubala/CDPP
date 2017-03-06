  # Emitting class Main {...}
    # Emitting void main(...) {...}
.globl _main
_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
    movl $0, %eax
    leave
    ret
