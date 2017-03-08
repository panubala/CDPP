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
        # Emitting A = 1
          # Emitting A
          subl $4, %esp
          # Emitting 1
          movl $1, %esi
        movl %esi, -4(%ebp)
        # Emitting B = 1
          # Emitting B
          subl $4, %esp
          # Emitting 1
          movl $1, %esi
        movl %esi, -8(%ebp)
        # Emitting a = (A * -(B))
          # Emitting a
          subl $4, %esp
          # Emitting (A * -(B))
            # Emitting A
            movl -4(%ebp), %esi
          pushl %esi
            # Emitting -(B)
              # Emitting B
              movl -8(%ebp), %esi
            negl %esi
          movl -16(%ebp), %edx
          addl $4, %esp
          imull %esi, %edx
        movl %edx, -12(%ebp)
        # Emitting b = (-(A) * B)
          # Emitting b
          subl $4, %esp
          # Emitting (-(A) * B)
            # Emitting -(A)
              # Emitting A
              movl -4(%ebp), %edx
            negl %edx
          pushl %edx
            # Emitting B
            movl -8(%ebp), %edx
          movl -20(%ebp), %esi
          addl $4, %esp
          imull %edx, %esi
        movl %esi, -16(%ebp)
        # Emitting c = -((A + B))
          # Emitting c
          subl $4, %esp
          # Emitting -((A + B))
            # Emitting (A + B)
              # Emitting A
              movl -4(%ebp), %esi
            pushl %esi
              # Emitting B
              movl -8(%ebp), %esi
            movl -24(%ebp), %edx
            addl $4, %esp
            addl %esi, %edx
          negl %edx
        movl %edx, -20(%ebp)
        # Emitting d = -((A * B))
          # Emitting d
          subl $4, %esp
          # Emitting -((A * B))
            # Emitting (A * B)
              # Emitting A
              movl -4(%ebp), %edx
            pushl %edx
              # Emitting B
              movl -8(%ebp), %edx
            movl -28(%ebp), %esi
            addl $4, %esp
            imull %edx, %esi
          negl %esi
        movl %esi, -24(%ebp)
        # Emitting write(a)
          # Emitting a
          movl -12(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write(b)
          # Emitting b
          movl -16(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write(c)
          # Emitting c
          movl -20(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write(d)
          # Emitting d
          movl -24(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
