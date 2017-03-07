  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
.LC2:
    .string "%d"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting write(53110)
          # Emitting 53110
          movl $53110, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
