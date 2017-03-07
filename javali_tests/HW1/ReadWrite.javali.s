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
        # Emitting i1 = read()
          # Emitting i1
          addl $-4, %esp
          # Emitting read()
          subl $4, %esp
          leal (%esp), %esi
          pushl %esi
          pushl $.LC2
          call _scanf
          addl $4, %esp
          movl -8(%ebp), %edx
        movl %edx, -4(%ebp)
        # Emitting write(i1)
          # Emitting i1
          movl -4(%ebp), %edi
        pushl %edi
        call _printf
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
