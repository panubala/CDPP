  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
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
        # Emitting writeln()
        pushl $.LC1
        call _printf
    movl $0, %eax
    leave
    ret
