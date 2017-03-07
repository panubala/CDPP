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
        # Emitting i0 = 5
          # Emitting i0
          addl $-4, %esp
          # Emitting 5
          movl $5, %esi
        movl %esi, -4(%ebp)
        # Emitting i1 = read()
          # Emitting i1
          addl $-4, %esp
          # Emitting read()
          pushl %esp
          call _scanf
          movl 0(%esp), %esi
        movl %esi, -8(%ebp)
        # Emitting write(i1)
          # Emitting i1
          movl -8(%ebp), %edi
        pushl %edi
        call _printf

    movl $0, %eax
    popl %ebp
    ret
